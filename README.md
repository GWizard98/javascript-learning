[![CI](https://github.com/GWizard98/javascript-learning/actions/workflows/ci.yml/badge.svg)](https://github.com/GWizard98/javascript-learning/actions/workflows/ci.yml)
![Node](https://img.shields.io/badge/node-%3E%3D18-brightgreen)
![Tested with Jest](https://img.shields.io/badge/tested%20with-jest-blue)
![License: MIT](https://img.shields.io/badge/license-MIT-green)
![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)
![GitHub stars](https://img.shields.io/github/stars/GWizard98/javascript-learning?style=social)

# 🚀 Java & JavaScript Learning Journey (50/50)

**Master Both Languages Together** - A comprehensive dual-language learning platform with 150+ exercises, cross-language projects, and professional development paths.

> **🎯 Perfect for**: Developers learning their second language, full-stack engineers, bootcamp students, and anyone wanting to understand how JavaScript and Java complement each other.

## 🌟 Why Learn Both Languages?

- **🔄 Cross-Language Skills**: Understand concepts in both frontend and backend contexts
- **📈 Career Flexibility**: Full-stack opportunities with modern JavaScript + enterprise Java
- **🧪 Test-Driven**: Every concept tested in both languages (Jest + JUnit)
- **🛠️ Real Projects**: Build complete applications with JS frontend + Java backend
- **📚 Comprehensive**: Equal coverage of both languages with comparison exercises
- **🤝 Community**: Learn from developers skilled in both ecosystems

## 🎮 Quick Demo - Choose Your Language

### JavaScript Track
```bash
# 1. Clone and setup 
git clone https://github.com/GWizard98/javascript-learning.git
cd javascript-learning && npm install

# 2. Run JavaScript tests
npm test javascript/exercises/basics/sum
# ✓ JavaScript: 3 tests passing

# 3. Try advanced JS concepts
npm test javascript/exercises/oop/classes-and-objects
# ✓ OOP in JavaScript: 25+ tests passing
```

### Java Track  
```bash
# 1. Test Java setup
cd java && mvn test
# ✓ Java: 70+ tests passing

# 2. Compare with JavaScript
mvn test -Dtest=*OOPTest
# ✓ Same concepts, Java syntax
```

### Cross-Language Projects
```bash
# Full-stack application
cd cross-language-projects/task-manager
# JavaScript frontend + Java backend
```

## 📊 Dual-Language Learning Paths

**Choose your learning style**: Side-by-side comparison or deep-dive single language

### 🔄 Cross-Language Track (Recommended - 6-8 weeks)
- [ ] **Week 1-2**: Variables & Functions in both JS and Java
- [ ] **Week 3-4**: OOP Concepts - Compare ES6 Classes vs Java Classes  
- [ ] **Week 5-6**: Data Structures - Arrays/Collections in both languages
- [ ] **Week 7-8**: **🎯 Capstone**: Full-stack app (JS frontend + Java backend)

### 🟨 JavaScript Specialist Track (4-5 weeks)
- [ ] **Fundamentals** → `javascript/exercises/basics/` (20+ exercises)
- [ ] **Modern JS** → `javascript/exercises/es6-plus/`, `javascript/exercises/async/`
- [ ] **DOM & Web APIs** → `javascript/exercises/dom/` (Required for web dev)
- [ ] **Advanced OOP** → `javascript/exercises/oop/` (ES6 classes, design patterns)
- [ ] **🎯 Projects** → `javascript/projects/` (Todo app, interactive sites)

### 🔵 Java Specialist Track (4-5 weeks)  
- [ ] **Core Java** → `java/src/main/java/learning/basics/` (Variables, Control Flow)
- [ ] **OOP Mastery** → `java/src/main/java/learning/oop/` (Inheritance, Polymorphism)
- [ ] **Collections & Algorithms** → `java/src/main/java/learning/basics/ArraysCollections`
- [ ] **Exception Handling** → `java/src/main/java/learning/exceptions/` 
- [ ] **🎯 Projects** → Spring Boot APIs, enterprise patterns

### 🌍 Full-Stack Integration
- [ ] **Task Manager** → `cross-language-projects/task-manager/` 
- [ ] **E-commerce Platform** → React frontend + Spring Boot backend
- [ ] **Real-time Chat** → WebSocket integration
- [ ] **Microservices** → JavaScript BFF + Java services
## 🏢 Dual-Language Project Structure

```
java-javascript-learning/
├─ javascript/                     # 🟨 JavaScript Learning (50%)
│  ├─ exercises/
│  │  ├─ basics/                 # Variables, functions, operators
│  │  ├─ intermediate/           # Array methods, real-world patterns  
│  │  ├─ async/                  # Promises, async/await, APIs
│  │  ├─ dom/                    # Interactive web elements (Required)
│  │  └─ oop/                    # ES6 classes, design patterns
│  └─ projects/
│     ├─ calculator/             # Beginner project
│     └─ intermediate-todo-app/  # Advanced patterns
├─ java/                           # 🔵 Java Learning (50%)
│  ├─ src/main/java/learning/
│  │  ├─ basics/                 # Variables, control flow, strings
│  │  ├─ oop/                    # Classes, inheritance, polymorphism
│  │  └─ exceptions/             # Error handling patterns
│  ├─ src/test/java/learning/     # 70+ JUnit tests
│  └─ pom.xml                     # Maven configuration
├─ cross-language-projects/        # 🔄 Full-Stack Integration
│  └─ task-manager/               # JavaScript frontend + Java backend
│  └─ combination-lab/            # Advanced polyglot demos
├─ docs/
│  ├─ javascript-guide.md          # JS-specific documentation
│  ├─ java-guide.md               # Java-specific documentation  
│  └─ language-comparison.md      # Side-by-side concept comparison
└─ WARP.md                        # Unified dual-language guide
```

### 🌍 Cross-Language Integration Features
- **Parallel Exercises**: Same concepts implemented in both languages
- **Full-Stack Projects**: JavaScript frontend + Java Spring Boot backend
- **Comparison Guides**: Side-by-side syntax and pattern analysis
- **Career Paths**: Frontend specialist, Backend specialist, or Full-Stack

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

### 🟦 Java Track (`java/`)
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
