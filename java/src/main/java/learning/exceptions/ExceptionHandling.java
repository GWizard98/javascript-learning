package learning.exceptions;

import java.io.*;
import java.util.*;

public class ExceptionHandling {
    
    /**
     * Demonstrates basic try-catch exception handling
     */
    public static int safeDivide(int numerator, int denominator) {
        try {
            return numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Demonstrates multiple catch blocks for different exception types
     */
    public static String parseAndFormat(String[] array, int index, String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            String element = array[index];
            return String.format("Element at index %d: %s, Number: %d", index, element, number);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: Array index out of bounds - " + e.getMessage();
        } catch (NumberFormatException e) {
            return "Error: Invalid number format - " + e.getMessage();
        } catch (NullPointerException e) {
            return "Error: Null array provided";
        }
    }
    
    /**
     * Demonstrates try-catch-finally block
     */
    public static String readFileContent(String filename) {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        
        try {
            reader = new FileReader(filename);
            bufferedReader = new BufferedReader(reader);
            StringBuilder content = new StringBuilder();
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\\n");
            }
            
            return content.toString().trim();
            
        } catch (FileNotFoundException e) {
            return "Error: File not found - " + filename;
        } catch (IOException e) {
            return "Error: Unable to read file - " + e.getMessage();
        } finally {
            // Always execute cleanup code
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file resources: " + e.getMessage());
            }
        }
    }
    
    /**
     * Demonstrates try-with-resources (automatic resource management)
     */
    public static String readFileWithResources(String filename) {
        try (FileReader reader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            StringBuilder content = new StringBuilder();
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\\n");
            }
            
            return content.toString().trim();
            
        } catch (FileNotFoundException e) {
            return "Error: File not found - " + filename;
        } catch (IOException e) {
            return "Error: Unable to read file - " + e.getMessage();
        }
        // Resources are automatically closed
    }
    
    /**
     * Demonstrates throwing custom exceptions
     */
    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        if (age > 150) {
            throw new IllegalArgumentException("Age seems unrealistic: " + age);
        }
    }
    
    /**
     * Demonstrates custom checked exceptions
     */
    public static void withdrawMoney(double balance, double amount) throws InsufficientFundsException, InvalidAccountException {
        if (balance < 0) {
            throw new InvalidAccountException("Account balance is negative");
        }
        if (amount <= 0) {
            throw new InvalidAccountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        // Withdrawal successful
        System.out.println("Withdrawal successful: " + amount);
    }
    
    /**
     * Demonstrates exception chaining
     */
    public static void processUserData(String userData) throws BankException {
        try {
            // Simulate parsing user data
            if (userData == null || userData.trim().isEmpty()) {
                throw new IllegalArgumentException("User data is empty");
            }
            
            String[] parts = userData.split(",");
            if (parts.length < 2) {
                throw new IllegalArgumentException("Invalid data format");
            }
            
            double amount = Double.parseDouble(parts[1]);
            withdrawMoney(1000.0, amount);
            
        } catch (NumberFormatException e) {
            throw new BankException("Invalid amount in user data", "PARSE_ERROR", e);
        } catch (InsufficientFundsException | InvalidAccountException e) {
            throw new BankException("Transaction failed", "TRANSACTION_ERROR", e);
        } catch (IllegalArgumentException e) {
            throw new BankException("Invalid user data format", "TRANSACTION_ERROR", e);
        }
    }
    
    /**
     * Demonstrates handling multiple exceptions with catch union
     */
    public static String safeOperation(String input) {
        try {
            // Multiple operations that can throw different exceptions
            int number = Integer.parseInt(input);
            int[] array = new int[5];
            array[10] = number; // Will throw ArrayIndexOutOfBoundsException
            
            return "Success: " + number;
            
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "Error: Invalid operation - " + e.getClass().getSimpleName();
        }
    }
    
    /**
     * Demonstrates rethrowing exceptions
     */
    public static void performCriticalOperation(String data) throws BankException {
        try {
            if (data.startsWith("CRITICAL_ERROR")) {
                throw new RuntimeException("Critical system error occurred");
            }
            processUserData(data);
        } catch (RuntimeException e) {
            // Log the error and rethrow as checked exception
            System.err.println("Critical error logged: " + e.getMessage());
            throw new BankException("System error during critical operation", "CRITICAL_ERROR", e);
        }
    }
    
    /**
     * Demonstrates exception handling best practices
     */
    public static Map<String, Object> robustDataProcessor(String[] dataArray) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", false);
        result.put("errors", new ArrayList<String>());
        result.put("processed", 0);
        
        if (dataArray == null) {
            ((List<String>) result.get("errors")).add("Input array is null");
            return result;
        }
        
        int processed = 0;
        List<String> errors = (List<String>) result.get("errors");
        
        for (int i = 0; i < dataArray.length; i++) {
            try {
                // Process each element
                if (dataArray[i] == null) {
                    throw new IllegalArgumentException("Null element at index " + i);
                }
                
                int value = Integer.parseInt(dataArray[i]);
                
                if (value < 0) {
                    throw new IllegalArgumentException("Negative value not allowed: " + value);
                }
                
                processed++;
                
            } catch (NumberFormatException e) {
                errors.add(String.format("Invalid number at index %d: %s", i, dataArray[i]));
            } catch (IllegalArgumentException e) {
                errors.add(String.format("Invalid data at index %d: %s", i, e.getMessage()));
            }
        }
        
        result.put("processed", processed);
        result.put("success", processed > 0 && errors.isEmpty());
        
        return result;
    }
}