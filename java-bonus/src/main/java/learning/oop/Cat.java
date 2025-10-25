package learning.oop;

/**
 * Cat class demonstrating inheritance and polymorphism
 */
public class Cat extends Animal {
    private String color;
    private boolean isIndoor;
    
    public Cat(String name, int age, String color) {
        super(name, age, "Cat");
        this.color = color;
        this.isIndoor = true; // Default to indoor
    }
    
    public Cat(String name, int age, String color, boolean isIndoor) {
        super(name, age, "Cat");
        this.color = color;
        this.isIndoor = isIndoor;
    }
    
    // Getters and setters
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
    
    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }
    
    // Implementation of abstract methods
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is gracefully walking on silent paws");
    }
    
    // Cat-specific methods
    public void purr() {
        System.out.println(name + " is purring contentedly");
    }
    
    public void scratch() {
        System.out.println(name + " is scratching the scratching post");
    }
    
    public void climb() {
        System.out.println(name + " is climbing up high");
    }
    
    public void hunt() {
        if (isIndoor) {
            System.out.println(name + " is hunting toy mice indoors");
        } else {
            System.out.println(name + " is hunting real prey outdoors");
        }
    }
    
    // Override parent method
    @Override
    public String getDescription() {
        String baseDescription = super.getDescription();
        return baseDescription + String.format(", color: %s, indoor: %s", 
                                               color, isIndoor ? "Yes" : "No");
    }
    
    @Override
    public String toString() {
        return String.format("Cat{name='%s', age=%d, color='%s', indoor=%s}", 
                           name, age, color, isIndoor);
    }
}