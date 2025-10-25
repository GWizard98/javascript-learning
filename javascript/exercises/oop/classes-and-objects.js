/**
 * JavaScript Object-Oriented Programming
 * 
 * These exercises parallel the Java OOP concepts to provide cross-language learning.
 * Compare with java/src/main/java/learning/oop/ for equivalent implementations.
 */

/**
 * 1. ES6 Classes with Constructor and Methods
 * JavaScript equivalent of Java's BankAccount class
 */
class BankAccount {
    // Private fields (ES2022 feature)
    #accountNumber;
    #balance;
    #accountHolderName;
    
    // Static private field
    static #nextAccountId = 1000;
    
    // Default constructor equivalent
    constructor(accountHolderName = "Unknown", initialBalance = 0) {
        this.#accountNumber = `ACC${BankAccount.#nextAccountId++}`;
        this.#accountHolderName = accountHolderName;
        this.#balance = initialBalance >= 0 ? initialBalance : 0;
    }
    
    // Getters (equivalent to Java getter methods)
    get accountNumber() {
        return this.#accountNumber;
    }
    
    get accountHolderName() {
        return this.#accountHolderName;
    }
    
    get balance() {
        return this.#balance;
    }
    
    // Setters with validation (equivalent to Java setter methods)
    set accountHolderName(name) {
        if (typeof name === 'string' && name.trim().length > 0) {
            this.#accountHolderName = name;
        }
    }
    
    // Business methods
    deposit(amount) {
        if (amount > 0) {
            this.#balance += amount;
            return true;
        }
        return false;
    }
    
    withdraw(amount) {
        if (amount > 0 && amount <= this.#balance) {
            this.#balance -= amount;
            return true;
        }
        return false;
    }
    
    transfer(toAccount, amount) {
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }
    
    calculateInterest(rate) {
        return this.#balance * rate / 100;
    }
    
    applyInterest(rate) {
        const interest = this.calculateInterest(rate);
        this.deposit(interest);
    }
    
    // Static method
    static getTotalAccountsCreated() {
        return BankAccount.#nextAccountId - 1000;
    }
    
    // Override toString (equivalent to Java's toString())
    toString() {
        return `BankAccount{accountNumber='${this.#accountNumber}', accountHolderName='${this.#accountHolderName}', balance=${this.#balance.toFixed(2)}}`;
    }
    
    // Custom equality method (JavaScript doesn't have automatic equals())
    equals(other) {
        return other instanceof BankAccount && 
               this.#accountNumber === other.#accountNumber;
    }
}

/**
 * 2. Inheritance and Polymorphism
 * JavaScript equivalent of Java's Animal hierarchy
 */
class Animal {
    constructor(name, age, species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }
    
    // Methods that can be inherited or overridden
    sleep() {
        console.log(`${this.name} is sleeping...`);
    }
    
    eat(food) {
        console.log(`${this.name} is eating ${food}`);
    }
    
    // Abstract-like methods (will be overridden in subclasses)
    makeSound() {
        throw new Error('makeSound() must be implemented by subclasses');
    }
    
    move() {
        throw new Error('move() must be implemented by subclasses');
    }
    
    getDescription() {
        return `${this.name} is a ${this.age}-year-old ${this.species}`;
    }
    
    toString() {
        return `Animal{name='${this.name}', age=${this.age}, species='${this.species}'}`;
    }
}

class Dog extends Animal {
    constructor(name, age, breed, isTrained = false) {
        super(name, age, 'Dog');
        this.breed = breed;
        this.isTrained = isTrained;
    }
    
    // Override abstract methods
    makeSound() {
        console.log(`${this.name} says: Woof! Woof!`);
    }
    
    move() {
        console.log(`${this.name} is running on four legs`);
    }
    
    // Dog-specific methods
    fetch() {
        console.log(`${this.name} is fetching the ball!`);
    }
    
    wagTail() {
        console.log(`${this.name} is wagging its tail happily!`);
    }
    
    train() {
        if (!this.isTrained) {
            this.isTrained = true;
            console.log(`${this.name} has been trained!`);
        } else {
            console.log(`${this.name} is already trained!`);
        }
    }
    
    // Override parent method
    getDescription() {
        const baseDescription = super.getDescription();
        return `${baseDescription}, breed: ${this.breed}, trained: ${this.isTrained ? 'Yes' : 'No'}`;
    }
    
    toString() {
        return `Dog{name='${this.name}', age=${this.age}, breed='${this.breed}', trained=${this.isTrained}}`;
    }
}

class Cat extends Animal {
    constructor(name, age, color, isIndoor = true) {
        super(name, age, 'Cat');
        this.color = color;
        this.isIndoor = isIndoor;
    }
    
    // Override abstract methods
    makeSound() {
        console.log(`${this.name} says: Meow!`);
    }
    
    move() {
        console.log(`${this.name} is gracefully walking on silent paws`);
    }
    
    // Cat-specific methods
    purr() {
        console.log(`${this.name} is purring contentedly`);
    }
    
    scratch() {
        console.log(`${this.name} is scratching the scratching post`);
    }
    
    climb() {
        console.log(`${this.name} is climbing up high`);
    }
    
    hunt() {
        if (this.isIndoor) {
            console.log(`${this.name} is hunting toy mice indoors`);
        } else {
            console.log(`${this.name} is hunting real prey outdoors`);
        }
    }
    
    // Override parent method
    getDescription() {
        const baseDescription = super.getDescription();
        return `${baseDescription}, color: ${this.color}, indoor: ${this.isIndoor ? 'Yes' : 'No'}`;
    }
    
    toString() {
        return `Cat{name='${this.name}', age=${this.age}, color='${this.color}', indoor=${this.isIndoor}}`;
    }
}

/**
 * 3. Composition and Advanced OOP Patterns
 * Demonstrate composition over inheritance
 */
class Engine {
    constructor(type, horsepower) {
        this.type = type;
        this.horsepower = horsepower;
        this.isRunning = false;
    }
    
    start() {
        if (!this.isRunning) {
            this.isRunning = true;
            console.log(`${this.type} engine started (${this.horsepower} HP)`);
            return true;
        }
        return false;
    }
    
    stop() {
        if (this.isRunning) {
            this.isRunning = false;
            console.log(`${this.type} engine stopped`);
            return true;
        }
        return false;
    }
    
    toString() {
        return `Engine{type='${this.type}', horsepower=${this.horsepower}, running=${this.isRunning}}`;
    }
}

class Car {
    constructor(make, model, year, engineType, horsepower) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = new Engine(engineType, horsepower); // Composition
        this.speed = 0;
        this.fuelLevel = 100;
    }
    
    start() {
        if (this.fuelLevel > 0) {
            return this.engine.start();
        } else {
            console.log('Cannot start: Out of fuel');
            return false;
        }
    }
    
    stop() {
        this.speed = 0;
        return this.engine.stop();
    }
    
    accelerate(amount) {
        if (this.engine.isRunning && this.fuelLevel > 0) {
            this.speed += amount;
            this.fuelLevel -= amount * 0.1; // Consume fuel
            console.log(`Accelerating to ${this.speed} mph`);
        }
    }
    
    brake(amount) {
        this.speed = Math.max(0, this.speed - amount);
        console.log(`Slowing down to ${this.speed} mph`);
    }
    
    refuel(amount) {
        this.fuelLevel = Math.min(100, this.fuelLevel + amount);
        console.log(`Refueled. Fuel level: ${this.fuelLevel}%`);
    }
    
    getInfo() {
        return {
            make: this.make,
            model: this.model,
            year: this.year,
            engine: this.engine.toString(),
            speed: this.speed,
            fuelLevel: this.fuelLevel
        };
    }
    
    toString() {
        return `Car{make='${this.make}', model='${this.model}', year=${this.year}, speed=${this.speed}}`;
    }
}

/**
 * 4. Factory Pattern and Design Patterns
 * JavaScript implementation of common design patterns
 */
class AnimalFactory {
    static createAnimal(type, name, age, ...args) {
        switch (type.toLowerCase()) {
            case 'dog':
                return new Dog(name, age, args[0] || 'Mixed', args[1] || false);
            case 'cat':
                return new Cat(name, age, args[0] || 'Brown', args[1] !== false);
            default:
                throw new Error(`Unknown animal type: ${type}`);
        }
    }
    
    static createAnimals(specifications) {
        return specifications.map(spec => 
            this.createAnimal(spec.type, spec.name, spec.age, ...spec.args || []));
    }
}

/**
 * 5. Singleton Pattern
 * Database connection simulator
 */
class DatabaseConnection {
    static #instance = null;
    
    constructor() {
        if (DatabaseConnection.#instance) {
            return DatabaseConnection.#instance;
        }
        
        this.connectionId = Math.random().toString(36).substr(2, 9);
        this.isConnected = false;
        DatabaseConnection.#instance = this;
    }
    
    static getInstance() {
        if (!DatabaseConnection.#instance) {
            DatabaseConnection.#instance = new DatabaseConnection();
        }
        return DatabaseConnection.#instance;
    }
    
    connect() {
        if (!this.isConnected) {
            this.isConnected = true;
            console.log(`Connected to database (ID: ${this.connectionId})`);
        }
    }
    
    disconnect() {
        if (this.isConnected) {
            this.isConnected = false;
            console.log(`Disconnected from database (ID: ${this.connectionId})`);
        }
    }
    
    query(sql) {
        if (this.isConnected) {
            console.log(`Executing query: ${sql}`);
            return { success: true, results: [] };
        } else {
            throw new Error('Database not connected');
        }
    }
}

/**
 * 6. Observer Pattern
 * Event system implementation
 */
class EventEmitter {
    constructor() {
        this.events = new Map();
    }
    
    on(eventName, listener) {
        if (!this.events.has(eventName)) {
            this.events.set(eventName, []);
        }
        this.events.get(eventName).push(listener);
    }
    
    off(eventName, listener) {
        if (this.events.has(eventName)) {
            const listeners = this.events.get(eventName);
            const index = listeners.indexOf(listener);
            if (index > -1) {
                listeners.splice(index, 1);
            }
        }
    }
    
    emit(eventName, ...args) {
        if (this.events.has(eventName)) {
            this.events.get(eventName).forEach(listener => {
                try {
                    listener(...args);
                } catch (error) {
                    console.error(`Error in event listener for ${eventName}:`, error);
                }
            });
        }
    }
    
    once(eventName, listener) {
        const onceWrapper = (...args) => {
            listener(...args);
            this.off(eventName, onceWrapper);
        };
        this.on(eventName, onceWrapper);
    }
}

// Export all classes for testing
if (typeof module !== 'undefined' && module.exports) {
    module.exports = {
        BankAccount,
        Animal,
        Dog,
        Cat,
        Engine,
        Car,
        AnimalFactory,
        DatabaseConnection,
        EventEmitter
    };
}