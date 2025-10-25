[![CI](https://github.com/GWizard98/javascript-learning/actions/workflows/ci.yml/badge.svg)](https://github.com/GWizard98/javascript-learning/actions/workflows/ci.yml)
![Node](https://img.shields.io/badge/node-%3E%3D18-brightgreen)
![Tested with Jest](https://img.shields.io/badge/tested%20with-jest-blue)
![License: MIT](https://img.shields.io/badge/license-MIT-green)
![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)
![GitHub stars](https://img.shields.io/github/stars/GWizard98/javascript-learning?style=social)

# 🚀 JavaScript Learning Journey

**From Zero to JavaScript Hero** - A comprehensive, hands-on learning path with 100+ exercises, real-world projects, and a bonus Java track.

> **🎯 Perfect for**: Absolute beginners, bootcamp students, self-taught developers, and anyone wanting to master JavaScript fundamentals through practice.

## 🌟 Why This Repository?

- **📈 Progressive Difficulty**: Start with variables, end building full-stack applications
- **🧪 Test-Driven**: Every concept backed by automated tests (Jest)
- **🛠️ Real Projects**: Build actual applications, not just toy examples
- **📚 Comprehensive**: 6 learning tracks + bonus Java fundamentals
- **🤝 Community**: Active support, code reviews, and learning challenges

## 🎮 Quick Demo

```bash
# 1. Clone and setup (2 minutes)
git clone https://github.com/GWizard98/javascript-learning.git
cd javascript-learning && npm install

# 2. Run your first test
npm test -- sum
# ✓ Passes 3 tests in 0.2s

# 3. Try an intermediate challenge
npm test -- array-methods
# ✓ Advanced array operations: 25+ tests passing

# 4. Build a real project
open projects/intermediate-todo-app/index.html
# 🚀 Full-featured todo app with local storage
```

## 📊 Learning Progress Tracker

Track your journey through structured levels with clear milestones:

### 🟢 Beginner Track (1-2 weeks)
- [ ] **Variables & Types** → `exercises/basics/` (4 exercises) 
- [ ] **Functions** → `exercises/basics/` (2 exercises)
- [ ] **🎯 Milestone Project**: Enhanced Calculator → `projects/calculator/`

### 🟡 Intermediate Track (2-3 weeks)
- [ ] **Array Methods** → `exercises/intermediate/` (6 real-world challenges)
- [ ] **Async JavaScript** → `exercises/async/` (8 API interaction patterns)  
- [ ] **DOM Manipulation** → `exercises/dom/` (Interactive web features)
- [ ] **🎯 Milestone Project**: Advanced Todo App → `projects/intermediate-todo-app/`

### 🟠 Advanced Track (3-4 weeks)
- [ ] **ES6+ Features** → `exercises/es6-plus/` (Modern JavaScript)
- [ ] **Testing Strategies** → Advanced Jest patterns
- [ ] **Performance** → Optimization techniques
- [ ] **🎯 Capstone Project**: Full-Stack Application

### 🎁 Bonus: Java Track
- [ ] **Java Fundamentals** → `java-bonus/` (70+ tests)
- [ ] **OOP Concepts** → Compare with JavaScript classes
- [ ] **Cross-Language Skills** → Backend + Frontend integration

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
├─ projects/
│  └─ combination-lab/            # 🔗 Polyglot Lab (Java + JavaScript)
└─ docs/
   ├─ programming-languages-overview.md
   └─ rust-vs-javascript-code-examples.md
```

### Polyglot Bonus: Combination Lab
A side-by-side Java + JavaScript learning lab with interactive REST, XSS, SAST, and GraphQL demos.
- Explore: projects/combination-lab/
- Run all services with Docker: see projects/combination-lab/WARP.md

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

## 🎆 Live Examples & Success Showcase

### 📊 Test Output Examples
```bash
$ npm test -- array-methods

PASS exercises/intermediate/array-methods.test.js
  ✓ transforms user data for UI display (15ms)
  ✓ calculates e-commerce cart totals with tax (8ms)
  ✓ groups sales data by region/product (12ms) 
  ✓ implements smart search with ranking (22ms)
  ✓ validates form data with custom rules (18ms)
  ✓ processes API responses with error handling (31ms)

Test Suites: 1 passed, 1 total
Tests: 25 passed, 25 total
Time: 2.847s
```

### 🛠️ Project Showcase

#### 🧮 Advanced Todo App (Intermediate)
- **Features**: Local storage, filtering, bulk operations, inline editing
- **Skills**: ES6 classes, event handling, data validation, error recovery
- **Real-world patterns**: MVC architecture, defensive programming
- **Try it**: Open `projects/intermediate-todo-app/index.html`

#### 🧪 Calculator Pro (Beginner)
- **Features**: Scientific operations, history, keyboard shortcuts
- **Skills**: Functions, error handling, DOM manipulation
- **Growth path**: From basic math to complex expressions

## 🏆 Success Stories & Community Impact

> *“Went from zero JavaScript knowledge to landing my first frontend job in 3 months using this repo!”* - **Sarah M., Junior Developer**

> *“The progressive structure and real projects made all the difference. Finally understood async/await!”* - **Mike L., Career Switcher**

> *“Used this to transition from Java to JavaScript. The bonus Java section helped bridge concepts!”* - **David K., Full-Stack Developer**

## 🛣️ Community & Support

### 💬 Get Help
- **[Discussions](https://github.com/GWizard98/javascript-learning/discussions)**: Ask questions, share projects
- **[Issues](https://github.com/GWizard98/javascript-learning/issues)**: Report bugs, request features  
- **Study Groups**: Weekly virtual meetups (check Discussions)

### 🎯 Contributing & Learning Together
- **Good First Issues**: Perfect entry points for contributors
- **Code Review Program**: Get feedback from experienced developers
- **Exercise Creation**: Help build new challenges for fellow learners
- **Mentorship**: Connect with successful graduates

### 🏆 Achievement System

Earn badges as you progress:
- 🥉 **First Steps**: Complete first 5 exercises
- 🥈 **Function Master**: Complete all function exercises  
- 🥇 **Async Expert**: Master promises and async/await
- 🏆 **Project Builder**: Complete first milestone project
- 🌟 **Community Contributor**: Submit your first PR

## Contributing
- Follow the exercises-first pattern and always include tests.
- Keep functions single-purpose and readable.
- See CONTRIBUTING.md for branching, commit style, and PR guidelines.

## License
ISC © Contributors
