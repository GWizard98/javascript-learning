[![CI](https://github.com/GWizard98/javascript-learning/actions/workflows/ci.yml/badge.svg)](https://github.com/GWizard98/javascript-learning/actions/workflows/ci.yml)
![Node](https://img.shields.io/badge/node-%3E%3D18-brightgreen)
![Tested with Jest](https://img.shields.io/badge/tested%20with-jest-blue)
![License: MIT](https://img.shields.io/badge/license-MIT-green)

# JavaScript Learning

A clean, test-driven JavaScript learning repository with bite-sized exercises, clear docs, and CI-ready setup.

- Node: >= 18
- Test Runner: Jest
- Structure: Exercises-first with unit tests

## Table of Contents
- Overview
- Project Structure
- Getting Started
- Running Tests
- Adding New Exercises
- Learning Path & Roadmap
- Contributing
- License

## Overview
This repository helps you master JavaScript fundamentals through hands-on exercises backed by unit tests. Each concept is introduced with a simple function and an accompanying spec to reinforce TDD habits from day one.

- Online Docs: https://GWizard98.github.io/javascript-learning

## Project Structure
```
javascript-learning/
├─ exercises/
│  └─ basics/
│     ├─ sum.js
│     ├─ sum.test.js
│     ├─ multiply.js
│     └─ multiply.test.js
├─ java-bonus/                    # 🎁 Bonus Java Learning Module
│  ├─ src/main/java/learning/     # Complete Java fundamentals
│  ├─ src/test/java/learning/     # 70+ JUnit tests
│  ├─ pom.xml                     # Maven configuration
│  └─ WARP.md                     # Java-specific instructions
└─ docs/
   ├─ programming-languages-overview.md
   └─ rust-vs-javascript-code-examples.md
```

## Getting Started
1) Install dependencies
```
npm ci || npm install
```
2) Run the test suite
```
npm test
```

## Running Tests
- Test files live next to their implementations and end with `.test.js`.
- Use `npm test` to run all tests or `npm test -- <pattern>` to filter, e.g.:
```
npm test -- sum
```

## Adding New Exercises
1) Create a new file in `exercises/<topic>/yourFunction.js`.
2) Create a matching spec `exercises/<topic>/yourFunction.test.js`.
3) Start with a failing test, implement the function, and iterate.

Example:
```
// exercises/strings/reverse.js
function reverse(s) { return s.split('').reverse().join(''); }
module.exports = reverse;

// exercises/strings/reverse.test.js
const reverse = require('./reverse');

test('reverses a string', () => {
  expect(reverse('abc')).toBe('cba');
});
```

## Learning Path & Roadmap

### JavaScript Track
- Basics: functions, numbers, strings
- Data structures: arrays, objects, maps/sets
- Control flow: conditionals, loops, iteration
- ES6+ features: arrow functions, destructuring, spread/rest, modules
- Error handling: try/catch, custom errors
- Async JS: promises, async/await, fetch
- Testing: mocking, coverage, testing strategies
- Bonus: DOM basics (optional), TypeScript primer (optional)

### 🎁 Java Bonus Track (`java-bonus/`)
Complete Java fundamentals with 70+ tests covering:
- Variables, data types, and type conversion
- String manipulation and StringBuilder
- Control flow: loops, conditionals, algorithms  
- Arrays, Collections (ArrayList, HashMap)
- Object-Oriented Programming: inheritance, polymorphism
- Exception handling with custom exceptions

```bash
# Quick start with Java bonus content
cd java-bonus/
mvn test  # Run all 70+ Java tests
```

See `java-bonus/WARP.md` for complete Java instructions.

## Contributing
- Follow the exercises-first pattern and always include tests.
- Keep functions single-purpose and readable.
- See CONTRIBUTING.md for branching, commit style, and PR guidelines.

## License
ISC © Contributors
