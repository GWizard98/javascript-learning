# Java Learning

A clean, test-driven Java learning repository with bite-sized exercises, clear docs, and CI-ready structure.

- JDK: >= 17
- Build: Maven
- Test Runner: JUnit 5 (Jupiter)
- Structure: Exercises-first with unit tests

## Project Structure
```
java-learning/
├─ exercises/
│  └─ basics/
│     └─ README.md (exercise prompts, optional)
├─ src/
│  ├─ main/java/learning/
│  │  ├─ App.java
│  │  └─ basics/
│  │     └─ Sum.java
│  └─ test/java/learning/
│     └─ basics/
│        └─ SumTest.java
└─ docs/
   └─ index.md
```

## Getting Started
1) Ensure you have JDK 17+
2) Run tests
```
mvn -q -e -DskipTests=false test
```

## Running Tests
- Tests live under `src/test/java` and use JUnit 5.
- Run all tests: `mvn test`
- Run a single class: `mvn -Dtest=learning.basics.SumTest test`

## Adding New Exercises
1) Create a new class in `src/main/java/learning/<topic>/YourClass.java`.
2) Create a matching test in `src/test/java/learning/<topic>/YourClassTest.java`.
3) Start with a failing test, implement the class, and iterate.

Example:
```java
// src/main/java/learning/strings/Reverse.java
package learning.strings;

public class Reverse {
  public static String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}

// src/test/java/learning/strings/ReverseTest.java
package learning.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseTest {
  @Test void reversesString() {
    assertEquals("cba", Reverse.reverse("abc"));
  }
}
```

## License
MIT © Contributors
