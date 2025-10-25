const tokenEl = document.querySelector('#token');
const out = document.querySelector('#out');
const usernameEl = document.querySelector('#username');
const secretEl = document.querySelector('#secret');

const SECURE_URL = 'http://localhost:8080/api/secure/hello';

// Base64URL helpers
const b64url = {
  encode: (buf) => btoa(String.fromCharCode(...new Uint8Array(buf)))
    .replace(/\+/g, '-').replace(/\//g, '_').replace(/=+$/,''),
  fromString: (s) => new TextEncoder().encode(s)
};

async function hmacSHA256(keyRaw, dataRaw) {
  const key = await crypto.subtle.importKey(
    'raw', b64url.fromString(keyRaw), { name: 'HMAC', hash: 'SHA-256' }, false, ['sign']
  );
  const sig = await crypto.subtle.sign('HMAC', key, dataRaw);
  return new Uint8Array(sig);
}

function utf8(s){ return new TextEncoder().encode(s); }

async function makeJwtHS256(payload, secret) {
  const header = { alg: 'HS256', typ: 'JWT' };
  const encHeader = b64url.encode(utf8(JSON.stringify(header)));
  const encPayload = b64url.encode(utf8(JSON.stringify(payload)));
  const toSign = utf8(`${encHeader}.${encPayload}`);
  const sig = await hmacSHA256(secret, toSign);
  const encSig = b64url.encode(sig);
  return `${encHeader}.${encPayload}.${encSig}`;
}

let token = null;

document.querySelector('#gen').addEventListener('click', async () => {
  const sub = (usernameEl.value || 'alice').trim();
  const secret = secretEl.value || 'dev-secret';
  token = await makeJwtHS256({ sub, iat: Math.floor(Date.now()/1000) }, secret);
  tokenEl.textContent = token;
});

document.querySelector('#call').addEventListener('click', async () => {
  out.textContent = 'Loading...';
  try {
    const res = await fetch(SECURE_URL, {
      headers: token ? { 'Authorization': `Bearer ${token}` } : {}
    });
    const text = await res.text();
    out.textContent = `HTTP ${res.status}\n` + text;
  } catch (e) {
    out.textContent = String(e);
  }
});
