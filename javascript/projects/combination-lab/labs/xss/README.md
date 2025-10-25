# XSS Lab

Purpose: experience client-side XSS and practice mitigations (encode/sanitize/input validation). The /xss/echo route intentionally reflects raw input.

How to run:
- Start the stack: ./scripts/dev.sh (or docker compose up --build)
- Open http://localhost:3000/xss/index.html

Exercises:
1) Basic reflected XSS:
   - Enter: <script>alert('xss')</script>
   - Observe alert.
2) HTML injection:
   - Enter: <img src=x onerror=alert('xss')>
3) Mitigate on client:
   - Edit labs/xss/public/vuln.js, switch from innerHTML to textContent.
   - Refresh and try payloads again.
4) Mitigate on server:
   - In apps/micro-js/src/server.js, encode output: res.send(`<p>You typed: ${escapeHtml(text)}</p>`)
   - Add escapeHtml utility or use a library, then rebuild micro-js container.
5) Discuss server-side validation in Java:
   - Add whitelist validation to apps/backend-java if you create an echo endpoint.

Notes:
- Real apps must validate on server and encode on output. Client mitigations are not sufficient alone.
