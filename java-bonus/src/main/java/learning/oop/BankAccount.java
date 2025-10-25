package learning.oop;

/**
 * Demonstrates encapsulation, constructors, and basic OOP concepts
 */
public class BankAccount {
    // Private fields (encapsulation)
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int nextAccountId = 1000;
    
    // Default constructor
    public BankAccount() {
        this.accountNumber = "ACC" + (nextAccountId++);
        this.accountHolderName = "Unknown";
        this.balance = 0.0;
    }
    
    // Parameterized constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = "ACC" + (nextAccountId++);
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance >= 0 ? initialBalance : 0.0;
    }
    
    // Copy constructor
    public BankAccount(BankAccount other) {
        this.accountNumber = "ACC" + (nextAccountId++); // New account gets new number
        this.accountHolderName = other.accountHolderName;
        this.balance = other.balance;
    }
    
    // Getters (accessor methods)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setters (mutator methods) with validation
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName != null && !accountHolderName.trim().isEmpty()) {
            this.accountHolderName = accountHolderName;
        }
    }
    
    // Business methods
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public boolean transfer(BankAccount toAccount, double amount) {
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }
    
    public double calculateInterest(double rate) {
        return balance * rate / 100;
    }
    
    public void applyInterest(double rate) {
        double interest = calculateInterest(rate);
        deposit(interest);
    }
    
    // Static method
    public static int getTotalAccountsCreated() {
        return nextAccountId - 1000;
    }
    
    // Override toString for better object representation
    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', accountHolderName='%s', balance=%.2f}", 
                           accountNumber, accountHolderName, balance);
    }
    
    // Override equals for object comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        BankAccount that = (BankAccount) obj;
        return accountNumber.equals(that.accountNumber);
    }
    
    // Override hashCode when overriding equals
    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}