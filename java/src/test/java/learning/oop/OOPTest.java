package learning.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OOPTest {
    
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    @BeforeEach
    void setUp() {
        // Capture System.out for testing println statements
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }
    
    void tearDown() {
        System.setOut(originalOut);
    }
    
    @Test
    void bankAccountConstructorsWork() {
        // Default constructor
        BankAccount account1 = new BankAccount();
        assertTrue(account1.getAccountNumber().startsWith("ACC"));
        assertEquals("Unknown", account1.getAccountHolderName());
        assertEquals(0.0, account1.getBalance(), 0.001);
        
        // Parameterized constructor
        BankAccount account2 = new BankAccount("John Doe", 1000.0);
        assertTrue(account2.getAccountNumber().startsWith("ACC"));
        assertEquals("John Doe", account2.getAccountHolderName());
        assertEquals(1000.0, account2.getBalance(), 0.001);
        
        // Negative initial balance should become 0
        BankAccount account3 = new BankAccount("Jane Doe", -500.0);
        assertEquals(0.0, account3.getBalance(), 0.001);
        
        // Copy constructor
        BankAccount account4 = new BankAccount(account2);
        assertEquals("John Doe", account4.getAccountHolderName());
        assertEquals(1000.0, account4.getBalance(), 0.001);
        assertNotEquals(account2.getAccountNumber(), account4.getAccountNumber()); // Different account numbers
    }
    
    @Test
    void bankAccountGettersSettersWork() {
        BankAccount account = new BankAccount("Alice", 500.0);
        
        // Test getters
        assertEquals("Alice", account.getAccountHolderName());
        assertEquals(500.0, account.getBalance(), 0.001);
        
        // Test setters
        account.setAccountHolderName("Alice Smith");
        assertEquals("Alice Smith", account.getAccountHolderName());
        
        // Test setter validation
        account.setAccountHolderName(""); // Should not change
        assertEquals("Alice Smith", account.getAccountHolderName());
        
        account.setAccountHolderName(null); // Should not change
        assertEquals("Alice Smith", account.getAccountHolderName());
    }
    
    @Test
    void bankAccountTransactionsWork() {
        BankAccount account = new BankAccount("Bob", 1000.0);
        
        // Test deposit
        assertTrue(account.deposit(500.0));
        assertEquals(1500.0, account.getBalance(), 0.001);
        
        assertFalse(account.deposit(-100.0)); // Negative deposit should fail
        assertFalse(account.deposit(0.0)); // Zero deposit should fail
        assertEquals(1500.0, account.getBalance(), 0.001); // Balance unchanged
        
        // Test withdrawal
        assertTrue(account.withdraw(300.0));
        assertEquals(1200.0, account.getBalance(), 0.001);
        
        assertFalse(account.withdraw(1500.0)); // Insufficient funds
        assertFalse(account.withdraw(-50.0)); // Negative withdrawal
        assertEquals(1200.0, account.getBalance(), 0.001); // Balance unchanged
    }
    
    @Test
    void bankAccountTransferWorks() {
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);
        
        // Successful transfer
        assertTrue(account1.transfer(account2, 200.0));
        assertEquals(800.0, account1.getBalance(), 0.001);
        assertEquals(700.0, account2.getBalance(), 0.001);
        
        // Failed transfer (insufficient funds)
        assertFalse(account1.transfer(account2, 1000.0));
        assertEquals(800.0, account1.getBalance(), 0.001); // Unchanged
        assertEquals(700.0, account2.getBalance(), 0.001); // Unchanged
    }
    
    @Test
    void bankAccountInterestCalculation() {
        BankAccount account = new BankAccount("Carol", 1000.0);
        
        double interest = account.calculateInterest(5.0); // 5% interest
        assertEquals(50.0, interest, 0.001);
        
        account.applyInterest(5.0);
        assertEquals(1050.0, account.getBalance(), 0.001);
    }
    
    @Test
    void bankAccountStaticMethodWorks() {
        int initialCount = BankAccount.getTotalAccountsCreated();
        
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount("Test", 100.0);
        
        assertEquals(initialCount + 2, BankAccount.getTotalAccountsCreated());
    }
    
    @Test
    void bankAccountEqualsAndHashCode() {
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 2000.0);
        BankAccount account3 = new BankAccount(account1); // Copy constructor
        
        // Same account number means equal
        assertEquals(account1, account1);
        assertNotEquals(account1, account2);
        assertNotEquals(account1, account3); // Different account numbers
        
        // Hash codes
        assertEquals(account1.hashCode(), account1.hashCode());
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }
    
    @Test
    void dogInheritanceWorks() {
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        
        // Test inherited properties and methods
        assertEquals("Buddy", dog.getName());
        assertEquals(3, dog.getAge());
        assertEquals("Dog", dog.getSpecies());
        
        // Test Dog-specific properties
        assertEquals("Golden Retriever", dog.getBreed());
        assertFalse(dog.isTrained());
        
        // Test training
        dog.train();
        assertTrue(dog.isTrained());
        
        tearDown(); // Restore System.out for assertions
        String output = outputStream.toString();
        assertTrue(output.contains("Buddy has been trained!"));
    }
    
    @Test
    void catInheritanceWorks() {
        Cat cat = new Cat("Whiskers", 2, "Orange");
        
        // Test inherited properties
        assertEquals("Whiskers", cat.getName());
        assertEquals(2, cat.getAge());
        assertEquals("Cat", cat.getSpecies());
        
        // Test Cat-specific properties
        assertEquals("Orange", cat.getColor());
        assertTrue(cat.isIndoor()); // Default is indoor
        
        // Test outdoor cat
        Cat outdoorCat = new Cat("Tiger", 4, "Striped", false);
        assertFalse(outdoorCat.isIndoor());
    }
    
    @Test
    void polymorphismWorks() {
        // Polymorphism: Animal references pointing to Dog and Cat objects
        Animal[] animals = {
            new Dog("Rex", 5, "German Shepherd"),
            new Cat("Luna", 3, "Black"),
            new Dog("Max", 2, "Bulldog", true)
        };
        
        // Test polymorphic behavior
        for (Animal animal : animals) {
            assertNotNull(animal.getName());
            assertTrue(animal.getAge() >= 0);
            assertNotNull(animal.getSpecies());
            
            // These methods will call the overridden versions
            animal.makeSound(); // Will call Dog.makeSound() or Cat.makeSound()
            animal.move(); // Will call Dog.move() or Cat.move()
        }
        
        tearDown();
        String output = outputStream.toString();
        
        // Verify that different animals made different sounds
        assertTrue(output.contains("Woof"));
        assertTrue(output.contains("Meow"));
        assertTrue(output.contains("running on four legs"));
        assertTrue(output.contains("gracefully walking"));
    }
    
    @Test
    void methodOverridingWorks() {
        Dog dog = new Dog("Buddy", 3, "Labrador", true);
        Cat cat = new Cat("Mittens", 2, "White", true);
        
        // Test overridden getDescription method
        String dogDescription = dog.getDescription();
        assertTrue(dogDescription.contains("Buddy"));
        assertTrue(dogDescription.contains("3-year-old"));
        assertTrue(dogDescription.contains("Dog"));
        assertTrue(dogDescription.contains("Labrador"));
        assertTrue(dogDescription.contains("trained: Yes"));
        
        String catDescription = cat.getDescription();
        assertTrue(catDescription.contains("Mittens"));
        assertTrue(catDescription.contains("2-year-old"));
        assertTrue(catDescription.contains("Cat"));
        assertTrue(catDescription.contains("White"));
        assertTrue(catDescription.contains("indoor: Yes"));
    }
    
    @Test
    void toStringMethodsWork() {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        String accountString = account.toString();
        assertTrue(accountString.contains("John Doe"));
        assertTrue(accountString.contains("1000.00"));
        
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        String dogString = dog.toString();
        assertTrue(dogString.contains("Buddy"));
        assertTrue(dogString.contains("3"));
        assertTrue(dogString.contains("Golden Retriever"));
        
        Cat cat = new Cat("Whiskers", 2, "Orange");
        String catString = cat.toString();
        assertTrue(catString.contains("Whiskers"));
        assertTrue(catString.contains("2"));
        assertTrue(catString.contains("Orange"));
    }
}