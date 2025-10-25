# Contributing

Thanks for your interest in improving this learning repository! Please follow these guidelines to keep contributions consistent and helpful.

## Getting Started
- Use Node >= 18
- Install dependencies: `npm ci` (or `npm install`)
- Run tests: `npm test`

## Workflow
1. Fork the repo and create a feature branch: `git checkout -b feat/topic-name`
2. Write code and tests (TDD preferred)
3. Keep functions small and focused; prefer clarity over cleverness
4. Ensure tests pass locally: `npm test`
5. Open a pull request with a clear description and checklist

## Commit Style
- Conventional commits encouraged:
  - `feat: add array chunking exercise`
  - `fix: handle negative input in multiply`
  - `docs: add async/await section`
  - `test: increase coverage for sum`

## Adding Exercises
- Place implementations under `exercises/<topic>/name.js`
- Place tests next to implementations: `exercises/<topic>/name.test.js`
- Include edge cases and descriptive test names

## Code Style
- Prefer standard JS features; no transpiler required
- Use descriptive names and JSDoc comments when helpful
- Avoid unnecessary dependencies

## PR Checklist
- [ ] Tests added/updated
- [ ] All tests pass locally
- [ ] Follows repo structure and naming
- [ ] Documentation updated if needed

Happy learning and building!