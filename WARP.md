# Combination Lab

A polyglot learning lab showing how Java (backend) and JavaScript (frontend + microservice) combine across REST and security scenarios. Includes interactive labs (XSS, SAST, REST) and one-command Docker orchestration.

## Repo status
- Apps:
  - apps/backend-java: Spring Boot minimal API (Java)
  - apps/micro-js: Express server + static site (JavaScript)
  - apps/frontend: Static frontend calling both services (JavaScript)
- Labs:
  - labs/xss: Client-side XSS demo + mitigations
  - labs/sast: Java insecure code sample for scanning
  - labs/rest: Fetch examples against Java API
  - labs/graphql: Spring GraphQL + JS client
  - labs/auth-jwt: JWT-protected Java endpoint + JS token client
- Orchestration: docker-compose.yml for all services

## Quick start
- Requirements: Docker and Docker Compose
- Start everything:
  - Mac/Linux: ./scripts/dev.sh
  - Stop: ./scripts/stop.sh
- Services:
  - Java API: http://localhost:8080/api/hello
  - JS microservice: http://localhost:3000/micro/ping
  - Frontend (static via micro): http://localhost:3000/

## Interactive labs
- XSS lab: http://localhost:3000/xss/index.html
  - Try payloads like <script>alert('xss')</script> and observe behavior.
- REST lab:
  - Open / (homepage) and click “Call Java API” to see JSON from backend.
- GraphQL lab: http://localhost:3000/graphql/index.html
  - Query Spring GraphQL at http://localhost:8080/graphql
- Auth (JWT) lab: http://localhost:3000/auth-jwt/index.html
  - Call secured Java endpoint at http://localhost:8080/api/secure/hello with a Bearer token
- SAST lab:
  - See labs/sast/java/UnsafeSqlExample.java and run your favorite SAST locally or in CI.

## Code architecture
- Communication: JS (frontend/micro) -> Java API via JSON over HTTP
- Security:
  - labs/xss shows reflection risks; sanitize/encode on client and server
  - backend enforces server-side validation

## Common commands (no local JDK/Node required)
- docker compose up --build  # build + run all
- docker compose down        # stop and remove

## Local (optional)
If you prefer running locally without Docker:
- Java: use Maven to run Spring Boot: mvn spring-boot:run (see apps/backend-java)
- JS micro: npm install && npm start (see apps/micro-js)

## Contributing
- Keep examples visually side-by-side in Java and JavaScript for learning impact
- Add small, focused labs; keep instructions in each lab’s README
