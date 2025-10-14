# Rust vs JavaScript: Visual Code Examples

**Companion Document to**: Comprehensive Programming Languages Overview  
**Focus**: Side-by-side syntax and approach comparisons  
**Date**: October 2024

---

## Table of Contents
1. [Basic Syntax Patterns](#basic-syntax-patterns)
2. [Variable Declarations](#variable-declarations)
3. [Functions and Parameters](#functions-and-parameters)
4. [Error Handling](#error-handling)
5. [Data Structures](#data-structures)
6. [Control Flow](#control-flow)
7. [Memory Management Examples](#memory-management-examples)
8. [Async Programming](#async-programming)
9. [Real-World Example: HTTP Request](#real-world-example-http-request)

---

# Basic Syntax Patterns

## Hello World

### Rust
```rust
fn main() {
    println!("Hello, world!");
}
console.log("Hello, world!");

# Variable Declarations

### Rust (Explicit Control)
```rust
let name = "Alice";          // immutable by default
let mut counter = 0;         // explicitly mutable  
counter += 1;                // this works

let age: i32 = 25;          // explicit type
const MAX_SIZE: usize = 1000; // constant
```

### JavaScript (Flexible Approach)
```javascript
let name = "Alice";          // mutable by default
name = "Bob";               // this works

const counter = 0;          // explicitly immutable
let age = 25;              // type inferred
```

**Philosophy:**
- **Rust**: "Immutable unless you say otherwise"
- **JavaScript**: "Mutable unless you say otherwise"

---

# Error Handling

### Rust (Explicit Results)
```rust
fn divide(a: f64, b: f64) -> Result<f64, String> {
    if b == 0.0 {
        Err("Cannot divide by zero".to_string())
    } else {
        Ok(a / b)
    }
}

// Using the result
match divide(10.0, 2.0) {
    Ok(result) => println!("Result: {}", result),
    Err(error) => println!("Error: {}", error),
}
```

### JavaScript (Try/Catch)
```javascript
function divide(a, b) {
    if (b === 0) {
        throw new Error("Cannot divide by zero");
    }
    return a / b;
}

// Using the function
try {
    const result = divide(10, 2);
    console.log(`Result: ${result}`);
} catch (error) {
    console.log(`Error: ${error.message}`);
}
```

**Philosophy:**
- **Rust**: Errors are values you must handle
- **JavaScript**: Errors are exceptions you can catch

---

# Control Flow

### Rust (Pattern Matching)
```rust
let number = 42;

// Match expression
let result = match number {
    0 => "zero",
    1..=10 => "small",
    11..=100 => "medium",
    _ => "large",
};

// For loop
for i in 0..5 {
    println!("Count: {}", i);
}
```

### JavaScript (Conditional Logic)
```javascript
let number = 42;

// If-else chain
let result;
if (number === 0) {
    result = "zero";
} else if (number <= 10) {
    result = "small";
} else if (number <= 100) {
    result = "medium";
} else {
    result = "large";
}

// For loop
for (let i = 0; i < 5; i++) {
    console.log(`Count: ${i}`);
}
```

---

# Async Programming

### Rust (Futures and Await)
```rust
use tokio;

async fn fetch_data() -> Result<String, Box<dyn std::error::Error>> {
    let response = reqwest::get("https://api.example.com/data").await?;
    let text = response.text().await?;
    Ok(text)
}

#[tokio::main]
async fn main() {
    match fetch_data().await {
        Ok(data) => println!("Data: {}", data),
        Err(e) => println!("Error: {}", e),
    }
}
```

### JavaScript (Promises and Async/Await)
```javascript
async function fetchData() {
    try {
        const response = await fetch('https://api.example.com/data');
        const data = await response.text();
        return data;
    } catch (error) {
        throw error;
    }
}

// Usage
fetchData()
    .then(data => console.log(`Data: ${data}`))
    .catch(error => console.log(`Error: ${error}`));
```

---

# Visual Summary

## Rust Philosophy in Code:
- **Explicit**: Types, mutability, error handling are all explicit
- **Safe**: Compiler prevents many runtime errors
- **Structured**: Strong type system and pattern matching

## JavaScript Philosophy in Code:
- **Flexible**: Dynamic typing and runtime modifications
- **Expressive**: Multiple ways to write the same thing
- **Accessible**: Forgiving syntax, easy to get started

---

*This document serves as a visual companion to the comprehensive programming languages overview, focusing specifically on syntax and approach differences between Rust and JavaScript.*
