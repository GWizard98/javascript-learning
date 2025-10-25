# GraphQL Lab

Goal: contrast Java GraphQL server with a simple JS client.

Run:
- Start stack: ./scripts/dev.sh
- Open http://localhost:3000/graphql/index.html

What it does:
- Java (Spring) exposes /graphql with query helloGraph(name: String)
- JS page posts a GraphQL query and renders the JSON response
