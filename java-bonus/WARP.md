# Java Learning Project - WARP Instructions

A comprehensive, test-driven Java learning repository with 70+ passing tests covering core Java fundamentals.

## 🚀 Quick Start

```bash
# Clone/navigate to project
cd /Users/akoyegordon/Projects/java-learning

# Run all tests
mvn test

# Run specific test class
mvn -Dtest=learning.basics.VariablesTest test
mvn -Dtest=learning.oop.OOPTest test
mvn -Dtest=learning.exceptions.ExceptionHandlingTest test

# Clean build
mvn clean compile test
```

## 📚 Project Structure

```
java-learning/
├── src/
│   ├── main/java/learning/
│   │   ├── App.java                    # Main entry point
│   │   ├── basics/                     # Core Java fundamentals
│   │   │   ├── Sum.java               # Basic arithmetic
│   │   │   ├── Variables.java         # Data types, constants, casting
│   │   │   ├── Strings.java           # String manipulation, StringBuilder
│   │   │   ├── ControlFlow.java       # Loops, conditionals, algorithms
│   │   │   └── ArraysCollections.java # Arrays, Lists, Maps, algorithms
│   │   ├── oop/                       # Object-Oriented Programming
│   │   │   ├── BankAccount.java       # Encapsulation, constructors
│   │   │   ├── Animal.java            # Abstract classes, inheritance
│   │   │   ├── Dog.java               # Concrete implementation
│   │   │   └── Cat.java               # Polymorphism demonstration
│   │   └── exceptions/                # Exception handling
│   │       ├── BankException.java     # Custom exception hierarchy
│   │       └── ExceptionHandling.java # Try-catch, finally, resources
│   └── test/java/learning/            # Comprehensive test suite
│       ├── basics/                    # 46 tests for fundamentals
│       ├── oop/                       # 12 tests for OOP concepts
│       └── exceptions/                # 12 tests for exception handling
├── pom.xml                            # Maven configuration (JDK 25, JUnit 5)
└── README.md                          # Project overview
```

## 🛠️ Development Environment

- **JDK**: OpenJDK 25 (Temurin) - installed via Homebrew
- **Build Tool**: Apache Maven 3.9.11
- **Testing**: JUnit 5 (Jupiter)
- **IDE Support**: IntelliJ IDEA, Eclipse, VS Code
- **Platform**: macOS (ARM64)

## 📖 Learning Modules

### 1. Variables & Data Types (`learning.basics.Variables`)
- **Concepts**: Primitive types, constants, type conversion
- **Examples**: Temperature conversion, compound interest, area calculations
- **Tests**: 6 comprehensive test methods
- **Key Methods**: `rectangleArea()`, `celsiusToFahrenheit()`, `compoundInterest()`

### 2. String Manipulation (`learning.basics.Strings`)
- **Concepts**: StringBuilder, regex, string algorithms
- **Examples**: Palindrome detection, anagram checking, title case conversion
- **Tests**: 9 test methods covering edge cases
- **Key Methods**: `isPalindrome()`, `areAnagrams()`, `compressString()`

### 3. Control Flow (`learning.basics.ControlFlow`)
- **Concepts**: If/else, loops (for/while/do-while), switch statements
- **Examples**: Grade calculation, prime numbers, Fibonacci sequence
- **Tests**: 15 test methods with boundary cases
- **Key Methods**: `factorial()`, `isPrime()`, `fibonacciSequence()`

### 4. Arrays & Collections (`learning.basics.ArraysCollections`)
- **Concepts**: Arrays, ArrayList, HashMap, algorithms
- **Examples**: Binary search, array rotation, frequency counting, two-sum
- **Tests**: 19 test methods covering all operations
- **Key Methods**: `binarySearch()`, `rotateRight()`, `twoSum()`
- **Advanced**: Custom `SimpleStack<T>` implementation with generics

### 5. Object-Oriented Programming (`learning.oop.*`)
- **Concepts**: Classes, inheritance, polymorphism, encapsulation
- **Examples**: Banking system, animal hierarchy
- **Tests**: 12 test methods covering OOP principles
- **Classes**:
  - `BankAccount`: Encapsulation, constructors, static methods
  - `Animal` (abstract): Inheritance base class
  - `Dog`/`Cat`: Concrete implementations demonstrating polymorphism

### 6. Exception Handling (`learning.exceptions.*`)
- **Concepts**: Try-catch-finally, custom exceptions, resource management
- **Examples**: Banking exceptions, file operations, robust error handling
- **Tests**: 12 test methods including edge cases
- **Custom Exceptions**: `BankException`, `InsufficientFundsException`
- **Advanced**: Exception chaining, try-with-resources

## 🧪 Testing Strategy

### Test Coverage: 70+ Passing Tests
- **Unit Tests**: Each method thoroughly tested
- **Edge Cases**: Boundary conditions, null inputs, invalid data
- **Exception Testing**: Proper exception throwing and handling
- **Integration**: Cross-class interactions (e.g., polymorphism)

### Test Execution
```bash
# All tests (70+ tests)
mvn test

# Specific categories
mvn -Dtest="*VariablesTest" test      # Data types & variables
mvn -Dtest="*StringsTest" test        # String operations
mvn -Dtest="*ControlFlowTest" test    # Control structures
mvn -Dtest="*ArraysCollectionsTest" test  # Collections & algorithms
mvn -Dtest="*OOPTest" test           # Object-oriented concepts
mvn -Dtest="*ExceptionHandlingTest" test  # Exception handling

# Single test method
mvn -Dtest="VariablesTest#rectangleAreaCalculatesCorrectly" test
```

## 🏗️ Build Commands

```bash
# Clean build
mvn clean

# Compile only
mvn compile

# Run tests with verbose output
mvn test -Dtest.verbose=true

# Generate test reports
mvn surefire-report:report

# Package (creates JAR)
mvn package

# Install to local Maven repository
mvn install
```

## 🎯 Learning Objectives Achieved

✅ **Java Fundamentals**
- Variables, data types, constants, type conversion
- String manipulation and StringBuilder usage
- Control flow structures and algorithms

✅ **Collections & Data Structures**
- Arrays, ArrayList, HashMap operations
- Algorithm implementation (search, sort, rotate)
- Custom data structures (Stack)

✅ **Object-Oriented Programming**
- Encapsulation with private fields and public methods
- Inheritance with abstract classes and concrete implementations
- Polymorphism with method overriding and dynamic dispatch
- Composition and aggregation relationships

✅ **Exception Handling**
- Try-catch-finally blocks and proper cleanup
- Custom exception hierarchies
- Exception chaining and rethrowing
- Resource management with try-with-resources

✅ **Best Practices**
- Test-driven development (TDD)
- Clean code principles
- Proper documentation and comments
- Maven project structure

## 🔄 Adding New Exercises

### 1. Create New Class
```java
// src/main/java/learning/[topic]/YourClass.java
package learning.[topic];

public class YourClass {
    public static String yourMethod(String input) {
        // Implementation
        return result;
    }
}
```

### 2. Create Test Class
```java
// src/test/java/learning/[topic]/YourClassTest.java
package learning.[topic];

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class YourClassTest {
    @Test
    void yourMethodWorksCorrectly() {
        assertEquals("expected", YourClass.yourMethod("input"));
    }
}
```

### 3. Run Tests
```bash
mvn test -Dtest=YourClassTest
```

## 📊 Project Statistics

- **Total Java Files**: 19 (10 main classes + 9 test classes)
- **Total Test Methods**: 70+
- **Lines of Code**: ~2,000+ (including tests and comments)
- **Test Coverage**: All public methods tested
- **Build Status**: ✅ All tests passing
- **Java Version**: JDK 25 (latest LTS features)

## 🚨 Common Issues & Solutions

### Maven Issues
```bash
# Maven not found
brew install maven

# Java version mismatch
java --version  # Should show JDK 17+
```

### Test Failures
```bash
# Run specific failing test
mvn -Dtest=ClassName#methodName test

# Clean rebuild
mvn clean compile test
```

### IDE Setup
- **IntelliJ IDEA**: Import as Maven project, set Project SDK to JDK 25
- **VS Code**: Install Java Extension Pack, configure java.home
- **Eclipse**: Import → Existing Maven Projects

## 📈 Next Steps

### Advanced Topics to Explore
1. **Generics**: Type safety and wildcards
2. **Streams API**: Functional programming patterns
3. **Concurrency**: Threads, ExecutorService, CompletableFuture
4. **Design Patterns**: Singleton, Factory, Observer, Strategy
5. **Spring Framework**: Dependency injection, web applications
6. **Database Integration**: JDBC, JPA/Hibernate
7. **Testing**: Mockito, integration testing, test containers

### Project Extensions
- Add more algorithm implementations (sorting, graph algorithms)
- Create a simple web API using Spring Boot
- Add database persistence layer
- Implement design patterns with practical examples
- Add concurrent programming exercises

---

**Status**: ✅ Complete - All 70+ tests passing
**Last Updated**: October 2024
**Java Version**: OpenJDK 25 (Temurin)
**Build Tool**: Maven 3.9.11