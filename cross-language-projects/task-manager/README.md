# Cross-Language Task Manager

A full-stack application demonstrating JavaScript and Java working together:

- **Frontend**: JavaScript (ES6+) with modern web APIs
- **Backend**: Java Spring Boot REST API
- **Database**: Java handles persistence, JavaScript handles UI

## 🏗️ Architecture

```
Frontend (JavaScript)          Backend (Java)
┌─────────────────┐            ┌──────────────────┐
│  task-app.js    │ ←→ HTTP →  │  TaskController  │
│  dom-utils.js   │            │  TaskService     │
│  api-client.js  │            │  TaskRepository  │
│  styles.css     │            │  Task (Entity)   │
└─────────────────┘            └──────────────────┘
```

## 🎯 Learning Objectives

### JavaScript Skills
- Fetch API for HTTP requests
- Async/await error handling
- DOM manipulation patterns
- ES6 modules and classes
- Event-driven programming

### Java Skills  
- Spring Boot REST API
- JPA/Hibernate entities
- Service layer patterns
- Exception handling
- Data validation

### Cross-Language Patterns
- RESTful API design
- JSON data exchange
- Error handling across layers
- Testing strategies for both sides

## 🚀 Getting Started

### Prerequisites
- Node.js (for JavaScript tools)
- Java 17+ and Maven (for backend)
- Modern web browser

### Running the Application

#### 1. Start Java Backend
```bash
cd backend/
mvn spring-boot:run
# Backend runs on http://localhost:8080
```

#### 2. Start JavaScript Frontend
```bash
cd frontend/
# Serve with any static server, e.g.:
python -m http.server 3000
# or
npx serve .
# Frontend runs on http://localhost:3000
```

#### 3. Test the Integration
```bash
# Run JavaScript tests
cd frontend/ && npm test

# Run Java tests  
cd backend/ && mvn test

# Run integration tests
npm run test:integration
```

## 📚 Language Comparison Examples

### Creating Objects

**JavaScript:**
```javascript
class Task {
    constructor(title, description) {
        this.id = Math.random().toString(36);
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = new Date();
    }
    
    toggle() {
        this.completed = !this.completed;
    }
}
```

**Java:**
```java
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String title;
    private String description;
    private boolean completed = false;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    public void toggle() {
        this.completed = !this.completed;
    }
    
    // getters/setters...
}
```

### Error Handling

**JavaScript:**
```javascript
async function createTask(taskData) {
    try {
        const response = await fetch('/api/tasks', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(taskData)
        });
        
        if (!response.ok) {
            throw new Error(`HTTP ${response.status}`);
        }
        
        return await response.json();
    } catch (error) {
        console.error('Failed to create task:', error);
        throw error;
    }
}
```

**Java:**
```java
@PostMapping("/tasks")
public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO taskDTO) {
    try {
        Task task = taskService.createTask(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    } catch (ValidationException e) {
        return ResponseEntity.badRequest().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
```

## 🔄 Data Flow Example

1. **User Action** (JavaScript): Click "Add Task" button
2. **Frontend Processing** (JavaScript): Validate input, create request
3. **HTTP Request** (JavaScript → Java): POST /api/tasks
4. **Backend Processing** (Java): Validate, save to database
5. **HTTP Response** (Java → JavaScript): Return created task
6. **UI Update** (JavaScript): Add task to DOM, update state

## 🧪 Testing Strategies

### JavaScript Tests (Jest)
```javascript
describe('Task API Client', () => {
    test('should create task successfully', async () => {
        const taskData = { title: 'Test Task', description: 'Test' };
        const result = await taskApi.create(taskData);
        expect(result.title).toBe('Test Task');
    });
});
```

### Java Tests (JUnit)
```java
@SpringBootTest
class TaskControllerTest {
    @Test
    void shouldCreateTaskSuccessfully() {
        TaskDTO taskDTO = new TaskDTO("Test Task", "Test");
        ResponseEntity<Task> response = taskController.createTask(taskDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
```

## 🎓 Key Learning Comparisons

| Concept | JavaScript | Java |
|---------|------------|------|
| **Classes** | ES6 classes with private fields | Classes with access modifiers |
| **Async** | Promises, async/await | CompletableFuture, @Async |
| **Error Handling** | try/catch with Promise rejections | try/catch with checked exceptions |
| **Testing** | Jest, Mocha, Jasmine | JUnit, Mockito, TestContainers |
| **Build Tools** | npm, webpack, rollup | Maven, Gradle |
| **Package Management** | npm packages | Maven dependencies |

## 🌟 Next Steps

After completing this project:
1. **Extend the backend**: Add user authentication (Java JWT)
2. **Enhance the frontend**: Add real-time updates (WebSockets)
3. **Deploy both**: JavaScript to CDN, Java to cloud platform
4. **Add TypeScript**: Type safety for JavaScript side
5. **Microservices**: Split Java backend into multiple services

This project demonstrates how JavaScript and Java complement each other in modern full-stack development!