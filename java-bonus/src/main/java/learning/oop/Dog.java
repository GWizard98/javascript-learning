package learning.oop;

/**
 * Dog class demonstrating inheritance from Animal
 */
public class Dog extends Animal {
    private String breed;
    private boolean isTrained;
    
    public Dog(String name, int age, String breed) {
        super(name, age, "Dog"); // Call parent constructor
        this.breed = breed;
        this.isTrained = false;
    }
    
    public Dog(String name, int age, String breed, boolean isTrained) {
        super(name, age, "Dog");
        this.breed = breed;
        this.isTrained = isTrained;
    }
    
    // Getters and setters for Dog-specific fields
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public boolean isTrained() {
        return isTrained;
    }
    
    public void setTrained(boolean trained) {
        isTrained = trained;
    }
    
    // Implementation of abstract methods
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is running on four legs");
    }
    
    // Dog-specific methods
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
    
    public void wagTail() {
        System.out.println(name + " is wagging its tail happily!");
    }
    
    public void train() {
        if (!isTrained) {
            isTrained = true;
            System.out.println(name + " has been trained!");
        } else {
            System.out.println(name + " is already trained!");
        }
    }
    
    // Override parent method
    @Override
    public String getDescription() {
        String baseDescription = super.getDescription();
        return baseDescription + String.format(", breed: %s, trained: %s", 
                                               breed, isTrained ? "Yes" : "No");
    }
    
    @Override
    public String toString() {
        return String.format("Dog{name='%s', age=%d, breed='%s', trained=%s}", 
                           name, age, breed, isTrained);
    }
}