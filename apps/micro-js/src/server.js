import express from 'express';
import cors from 'cors';
import morgan from 'morgan';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const port = process.env.PORT || 3000;
const BACKEND_URL = process.env.BACKEND_URL || 'http://localhost:8080';

app.use(cors());
app.use(morgan('dev'));
app.use(express.json());

// Static frontend and labs
app.use('/', express.static(path.join(__dirname, '..', 'public')));
app.use('/xss', express.static(path.join(__dirname, '..', 'public', 'xss')));

// Health
app.get('/micro/ping', (req, res) => {
  res.json({ message: 'pong', language: 'JavaScript', framework: 'Express' });
});

// Proxy helper to Java backend example
app.get('/micro/java-hello', async (req, res) => {
  try {
    const r = await fetch(`${BACKEND_URL}/api/hello`);
    const data = await r.json();
    res.json({ via: 'micro-js', java: data });
  } catch (e) {
    res.status(502).json({ error: 'Unable to reach backend', detail: String(e) });
  }
});

// XSS demo endpoint (intentionally unsafe reflection into HTML)
app.get('/xss/echo', (req, res) => {
  const text = req.query.text ?? '';
  res.set('Content-Type', 'text/html');
  // WARNING: intentionally unsafe for the lab
  res.send(`<p>You typed: ${text}</p>`);
});

app.listen(port, () => {
  console.log(`micro-js listening on http://localhost:${port} (backend: ${BACKEND_URL})`);
});
