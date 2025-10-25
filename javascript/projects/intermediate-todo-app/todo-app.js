/**
 * Intermediate Todo App - Real-World JavaScript Patterns
 * 
 * This project bridges beginner exercises with advanced concepts:
 * - ES6+ features (classes, modules, destructuring, async/await)
 * - Event handling and DOM manipulation
 * - Local storage persistence
 * - Error handling and validation
 * - Responsive design principles
 * - Testing-friendly architecture
 */

class TodoApp {
    constructor(container) {
        this.container = document.querySelector(container);
        this.todos = [];
        this.filter = 'all'; // 'all', 'active', 'completed'
        this.nextId = 1;
        
        this.init();
    }
    
    init() {
        this.loadFromStorage();
        this.render();
        this.bindEvents();
    }
    
    // ===== CORE TODO OPERATIONS =====
    
    addTodo(text) {
        if (!this.validateTodoText(text)) {
            throw new Error('Todo text must be between 1 and 200 characters');
        }
        
        const todo = {
            id: this.nextId++,
            text: text.trim(),
            completed: false,
            createdAt: new Date().toISOString(),
            updatedAt: new Date().toISOString()
        };
        
        this.todos.push(todo);
        this.saveToStorage();
        this.render();
        return todo;
    }
    
    deleteTodo(id) {
        const initialLength = this.todos.length;
        this.todos = this.todos.filter(todo => todo.id !== id);
        
        if (this.todos.length === initialLength) {
            throw new Error(`Todo with id ${id} not found`);
        }
        
        this.saveToStorage();
        this.render();
    }
    
    toggleTodo(id) {
        const todo = this.todos.find(t => t.id === id);
        if (!todo) {
            throw new Error(`Todo with id ${id} not found`);
        }
        
        todo.completed = !todo.completed;
        todo.updatedAt = new Date().toISOString();
        
        this.saveToStorage();
        this.render();
        return todo;
    }
    
    editTodo(id, newText) {
        if (!this.validateTodoText(newText)) {
            throw new Error('Todo text must be between 1 and 200 characters');
        }
        
        const todo = this.todos.find(t => t.id === id);
        if (!todo) {
            throw new Error(`Todo with id ${id} not found`);
        }
        
        todo.text = newText.trim();
        todo.updatedAt = new Date().toISOString();
        
        this.saveToStorage();
        this.render();
        return todo;
    }
    
    // ===== FILTERING AND SEARCH =====
    
    setFilter(filter) {
        const validFilters = ['all', 'active', 'completed'];
        if (!validFilters.includes(filter)) {
            throw new Error(`Invalid filter: ${filter}. Must be one of: ${validFilters.join(', ')}`);
        }
        
        this.filter = filter;
        this.render();
    }
    
    getFilteredTodos() {
        switch (this.filter) {
            case 'active':
                return this.todos.filter(todo => !todo.completed);
            case 'completed':
                return this.todos.filter(todo => todo.completed);
            default:
                return this.todos;
        }
    }
    
    searchTodos(query) {
        if (!query) return this.getFilteredTodos();
        
        const normalizedQuery = query.toLowerCase().trim();
        return this.getFilteredTodos().filter(todo =>
            todo.text.toLowerCase().includes(normalizedQuery)
        );
    }
    
    // ===== BATCH OPERATIONS =====
    
    toggleAllTodos(completed) {
        const todosToUpdate = this.todos.filter(todo => todo.completed !== completed);
        
        todosToUpdate.forEach(todo => {
            todo.completed = completed;
            todo.updatedAt = new Date().toISOString();
        });
        
        if (todosToUpdate.length > 0) {
            this.saveToStorage();
            this.render();
        }
        
        return todosToUpdate.length;
    }
    
    clearCompleted() {
        const completedCount = this.todos.filter(todo => todo.completed).length;
        this.todos = this.todos.filter(todo => !todo.completed);
        
        if (completedCount > 0) {
            this.saveToStorage();
            this.render();
        }
        
        return completedCount;
    }
    
    // ===== PERSISTENCE =====
    
    saveToStorage() {
        try {
            const data = {
                todos: this.todos,
                nextId: this.nextId,
                filter: this.filter,
                savedAt: new Date().toISOString()
            };
            localStorage.setItem('todo-app-data', JSON.stringify(data));
        } catch (error) {
            console.error('Failed to save to localStorage:', error);
            this.showError('Failed to save data. Your changes may be lost.');
        }
    }
    
    loadFromStorage() {
        try {
            const saved = localStorage.getItem('todo-app-data');
            if (saved) {
                const data = JSON.parse(saved);
                this.todos = data.todos || [];
                this.nextId = data.nextId || 1;
                this.filter = data.filter || 'all';
                
                // Validate loaded data
                this.validateLoadedData();
            }
        } catch (error) {
            console.error('Failed to load from localStorage:', error);
            this.showError('Failed to load saved data. Starting fresh.');
            this.todos = [];
            this.nextId = 1;
            this.filter = 'all';
        }
    }
    
    // ===== VALIDATION =====
    
    validateTodoText(text) {
        return typeof text === 'string' && 
               text.trim().length > 0 && 
               text.trim().length <= 200;
    }
    
    validateLoadedData() {
        // Ensure todos is an array
        if (!Array.isArray(this.todos)) {
            this.todos = [];
        }
        
        // Filter out invalid todos
        this.todos = this.todos.filter(todo => {
            return todo && 
                   typeof todo.id === 'number' &&
                   this.validateTodoText(todo.text) &&
                   typeof todo.completed === 'boolean';
        });
        
        // Ensure nextId is valid
        if (typeof this.nextId !== 'number' || this.nextId < 1) {
            this.nextId = Math.max(...this.todos.map(t => t.id), 0) + 1;
        }
    }
    
    // ===== STATISTICS =====
    
    getStats() {
        const total = this.todos.length;
        const completed = this.todos.filter(todo => todo.completed).length;
        const active = total - completed;
        
        return {
            total,
            completed,
            active,
            completionPercentage: total > 0 ? Math.round((completed / total) * 100) : 0
        };
    }
    
    // ===== UI RENDERING =====
    
    render() {
        const filteredTodos = this.getFilteredTodos();
        const stats = this.getStats();
        
        this.container.innerHTML = `
            <div class="todo-app">
                <header class="todo-header">
                    <h1>📝 Advanced Todo App</h1>
                    <div class="stats">
                        ${stats.total} total, ${stats.active} active, ${stats.completed} completed
                        ${stats.total > 0 ? `(${stats.completionPercentage}%)` : ''}
                    </div>
                </header>
                
                <div class="todo-input-section">
                    <input 
                        type="text" 
                        class="todo-input" 
                        placeholder="What needs to be done?"
                        maxlength="200"
                    >
                    <button class="add-btn">Add Todo</button>
                </div>
                
                <div class="todo-controls">
                    <div class="filters">
                        <button class="filter-btn ${this.filter === 'all' ? 'active' : ''}" data-filter="all">
                            All (${stats.total})
                        </button>
                        <button class="filter-btn ${this.filter === 'active' ? 'active' : ''}" data-filter="active">
                            Active (${stats.active})
                        </button>
                        <button class="filter-btn ${this.filter === 'completed' ? 'active' : ''}" data-filter="completed">
                            Completed (${stats.completed})
                        </button>
                    </div>
                    
                    <div class="bulk-actions">
                        ${stats.total > 0 ? `
                            <button class="bulk-btn" data-action="toggle-all">
                                ${stats.active > 0 ? 'Complete All' : 'Mark All Active'}
                            </button>
                        ` : ''}
                        ${stats.completed > 0 ? `
                            <button class="bulk-btn danger" data-action="clear-completed">
                                Clear Completed (${stats.completed})
                            </button>
                        ` : ''}
                    </div>
                </div>
                
                <ul class="todo-list">
                    ${filteredTodos.map(todo => this.renderTodo(todo)).join('')}
                </ul>
                
                ${filteredTodos.length === 0 ? this.renderEmptyState() : ''}
                
                <div class="error-message" style="display: none;"></div>
            </div>
        `;
        
        this.updateDocumentTitle(stats);
    }
    
    renderTodo(todo) {
        return `
            <li class="todo-item ${todo.completed ? 'completed' : ''}" data-id="${todo.id}">
                <div class="todo-content">
                    <input 
                        type="checkbox" 
                        class="todo-checkbox"
                        ${todo.completed ? 'checked' : ''}
                    >
                    <span class="todo-text" title="${this.escapeHtml(todo.text)}">
                        ${this.escapeHtml(todo.text)}
                    </span>
                    <div class="todo-meta">
                        <small>Created: ${this.formatDate(todo.createdAt)}</small>
                        ${todo.updatedAt !== todo.createdAt ? 
                            `<small>Updated: ${this.formatDate(todo.updatedAt)}</small>` : ''}
                    </div>
                </div>
                <div class="todo-actions">
                    <button class="edit-btn" title="Edit todo">✏️</button>
                    <button class="delete-btn" title="Delete todo">🗑️</button>
                </div>
            </li>
        `;
    }
    
    renderEmptyState() {
        const messages = {
            all: "No todos yet. Add one above! 👆",
            active: "All done! 🎉 Great job staying productive!",
            completed: "No completed todos. Keep working! 💪"
        };
        
        return `
            <div class="empty-state">
                <div class="empty-icon">${this.filter === 'active' ? '🎉' : '📝'}</div>
                <p>${messages[this.filter]}</p>
            </div>
        `;
    }
    
    // ===== EVENT HANDLING =====
    
    bindEvents() {
        this.container.addEventListener('click', this.handleClick.bind(this));
        this.container.addEventListener('keydown', this.handleKeydown.bind(this));
        this.container.addEventListener('change', this.handleChange.bind(this));
    }
    
    handleClick(event) {
        const { target } = event;
        
        try {
            if (target.classList.contains('add-btn')) {
                this.handleAddTodo();
            } else if (target.classList.contains('delete-btn')) {
                this.handleDeleteTodo(target);
            } else if (target.classList.contains('edit-btn')) {
                this.handleEditTodo(target);
            } else if (target.classList.contains('filter-btn')) {
                this.setFilter(target.dataset.filter);
            } else if (target.classList.contains('bulk-btn')) {
                this.handleBulkAction(target.dataset.action);
            }
        } catch (error) {
            this.showError(error.message);
        }
    }
    
    handleKeydown(event) {
        if (event.key === 'Enter') {
            if (event.target.classList.contains('todo-input')) {
                this.handleAddTodo();
            }
        } else if (event.key === 'Escape') {
            this.clearError();
        }
    }
    
    handleChange(event) {
        if (event.target.classList.contains('todo-checkbox')) {
            const todoId = parseInt(event.target.closest('.todo-item').dataset.id);
            try {
                this.toggleTodo(todoId);
            } catch (error) {
                this.showError(error.message);
            }
        }
    }
    
    // ===== SPECIFIC EVENT HANDLERS =====
    
    handleAddTodo() {
        const input = this.container.querySelector('.todo-input');
        const text = input.value.trim();
        
        if (!text) {
            this.showError('Please enter a todo item');
            input.focus();
            return;
        }
        
        try {
            this.addTodo(text);
            input.value = '';
            input.focus();
            this.clearError();
        } catch (error) {
            this.showError(error.message);
        }
    }
    
    handleDeleteTodo(button) {
        const todoId = parseInt(button.closest('.todo-item').dataset.id);
        
        if (confirm('Are you sure you want to delete this todo?')) {
            try {
                this.deleteTodo(todoId);
                this.clearError();
            } catch (error) {
                this.showError(error.message);
            }
        }
    }
    
    handleEditTodo(button) {
        const todoItem = button.closest('.todo-item');
        const todoId = parseInt(todoItem.dataset.id);
        const textSpan = todoItem.querySelector('.todo-text');
        const currentText = textSpan.textContent;
        
        // Create inline editor
        const input = document.createElement('input');
        input.type = 'text';
        input.value = currentText;
        input.className = 'todo-edit-input';
        input.maxLength = 200;
        
        const saveEdit = () => {
            const newText = input.value.trim();
            if (newText && newText !== currentText) {
                try {
                    this.editTodo(todoId, newText);
                    this.clearError();
                } catch (error) {
                    this.showError(error.message);
                    textSpan.textContent = currentText;
                }
            } else {
                textSpan.textContent = currentText;
            }
        };
        
        const cancelEdit = () => {
            textSpan.textContent = currentText;
        };
        
        input.addEventListener('blur', saveEdit);
        input.addEventListener('keydown', (e) => {
            if (e.key === 'Enter') {
                input.blur();
            } else if (e.key === 'Escape') {
                cancelEdit();
            }
        });
        
        textSpan.textContent = '';
        textSpan.appendChild(input);
        input.focus();
        input.select();
    }
    
    handleBulkAction(action) {
        try {
            if (action === 'toggle-all') {
                const stats = this.getStats();
                const completed = stats.active === 0;
                const count = this.toggleAllTodos(!completed);
                this.showSuccess(`${completed ? 'Marked' : 'Completed'} ${count} todos`);
            } else if (action === 'clear-completed') {
                if (confirm('Are you sure you want to clear all completed todos?')) {
                    const count = this.clearCompleted();
                    this.showSuccess(`Cleared ${count} completed todos`);
                }
            }
        } catch (error) {
            this.showError(error.message);
        }
    }
    
    // ===== UTILITY METHODS =====
    
    showError(message) {
        const errorDiv = this.container.querySelector('.error-message');
        errorDiv.textContent = message;
        errorDiv.style.display = 'block';
        errorDiv.className = 'error-message error';
        
        setTimeout(() => this.clearError(), 5000);
    }
    
    showSuccess(message) {
        const errorDiv = this.container.querySelector('.error-message');
        errorDiv.textContent = message;
        errorDiv.style.display = 'block';
        errorDiv.className = 'error-message success';
        
        setTimeout(() => this.clearError(), 3000);
    }
    
    clearError() {
        const errorDiv = this.container.querySelector('.error-message');
        if (errorDiv) {
            errorDiv.style.display = 'none';
            errorDiv.textContent = '';
        }
    }
    
    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }
    
    formatDate(isoString) {
        return new Date(isoString).toLocaleDateString('en-US', {
            month: 'short',
            day: 'numeric',
            hour: '2-digit',
            minute: '2-digit'
        });
    }
    
    updateDocumentTitle(stats) {
        document.title = stats.active > 0 ? 
            `(${stats.active}) Todo App` : 
            'Todo App';
    }
    
    // ===== PUBLIC API FOR TESTING =====
    
    // Export methods for testing
    getTodos() {
        return [...this.todos];
    }
    
    getFilter() {
        return this.filter;
    }
    
    clear() {
        this.todos = [];
        this.nextId = 1;
        this.filter = 'all';
        this.saveToStorage();
        this.render();
    }
}

// Export for testing and module usage
if (typeof module !== 'undefined' && module.exports) {
    module.exports = TodoApp;
}

// Auto-initialize if in browser and DOM is ready
if (typeof window !== 'undefined') {
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', () => {
            new TodoApp('#app');
        });
    } else {
        new TodoApp('#app');
    }
}