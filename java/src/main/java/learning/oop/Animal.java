package learning.oop;

/**
 * Abstract base class demonstrating inheritance and polymorphism
 */
public abstract class Animal {
    protected String name;
    protected int age;
    protected String species;
    
    // Constructor
    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }
    
    // Concrete methods (inherited by subclasses)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    
    public String getSpecies() {
        return species;
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
    
    public void eat(String food) {
        System.out.println(name + " is eating " + food);
    }
    
    // Abstract methods (must be implemented by subclasses)
    public abstract void makeSound();
    public abstract void move();
    
    // Method that can be overridden
    public String getDescription() {
        return String.format("%s is a %d-year-old %s", name, age, species);
    }
    
    @Override
    public String toString() {
        return String.format("Animal{name='%s', age=%d, species='%s'}", name, age, species);
    }
}