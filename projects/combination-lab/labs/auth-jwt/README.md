# Auth (JWT) Lab

Goal: learn how JWT protects Java APIs and how JS attaches tokens.

Run:
- Start stack: ./scripts/dev.sh
- Open http://localhost:3000/auth-jwt/index.html

What it does:
- Java exposes a protected endpoint: GET http://localhost:8080/api/secure/hello (requires Bearer JWT)
- JS page generates an HS256 JWT in the browser (lab-only) and calls the endpoint

Notes:
- Default secret is `dev-secret` (NOT for production). Change via env: JWT_SECRET=your-secret
- In real apps, tokens are minted by an auth server, not the browser client.
