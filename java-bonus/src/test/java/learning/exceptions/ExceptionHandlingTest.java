package learning.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class ExceptionHandlingTest {
    
    private ByteArrayOutputStream outputStream;
    private ByteArrayOutputStream errorStream;
    private PrintStream originalOut;
    private PrintStream originalErr;
    
    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        errorStream = new ByteArrayOutputStream();
        originalOut = System.out;
        originalErr = System.err;
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));
    }
    
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    @Test
    void safeDivideHandlesExceptions() {
        // Normal division
        assertEquals(5, ExceptionHandling.safeDivide(10, 2));
        assertEquals(3, ExceptionHandling.safeDivide(10, 3));
        
        // Division by zero
        assertEquals(0, ExceptionHandling.safeDivide(10, 0));
        
        tearDown();
        String output = outputStream.toString();
        assertTrue(output.contains("Cannot divide by zero"));
    }
    
    @Test
    void parseAndFormatHandlesMultipleExceptions() {
        String[] testArray = {"hello", "world", "java"};
        
        // Normal operation
        String result = ExceptionHandling.parseAndFormat(testArray, 0, "123");
        assertTrue(result.contains("Element at index 0: hello, Number: 123"));
        
        // Array index out of bounds
        result = ExceptionHandling.parseAndFormat(testArray, 5, "123");
        assertTrue(result.contains("Array index out of bounds"));
        
        // Number format exception
        result = ExceptionHandling.parseAndFormat(testArray, 0, "invalid");
        assertTrue(result.contains("Invalid number format"));
        
        // Null pointer exception
        result = ExceptionHandling.parseAndFormat(null, 0, "123");
        assertTrue(result.contains("Null array provided"));
    }
    
    @Test
    void readFileContentHandlesMissingFile() {
        String result = ExceptionHandling.readFileContent("nonexistent-file.txt");
        assertTrue(result.contains("File not found"));
    }
    
    @Test
    void readFileWithResourcesHandlesMissingFile() {
        String result = ExceptionHandling.readFileWithResources("nonexistent-file.txt");
        assertTrue(result.contains("File not found"));
    }
    
    @Test
    void validateAgeThrowsCorrectExceptions() {
        // Valid ages should not throw
        assertDoesNotThrow(() -> ExceptionHandling.validateAge(25));
        assertDoesNotThrow(() -> ExceptionHandling.validateAge(0));
        assertDoesNotThrow(() -> ExceptionHandling.validateAge(150));
        
        // Invalid ages should throw
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
                                                          () -> ExceptionHandling.validateAge(-5));
        assertTrue(exception1.getMessage().contains("cannot be negative"));
        
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, 
                                                          () -> ExceptionHandling.validateAge(200));
        assertTrue(exception2.getMessage().contains("unrealistic"));
    }
    
    @Test
    void withdrawMoneyThrowsCustomExceptions() {
        // Valid withdrawal should not throw
        assertDoesNotThrow(() -> ExceptionHandling.withdrawMoney(1000.0, 500.0));
        
        // Invalid account balance
        InvalidAccountException exception1 = assertThrows(InvalidAccountException.class,
                                                         () -> ExceptionHandling.withdrawMoney(-100.0, 50.0));
        assertTrue(exception1.getMessage().contains("negative"));
        assertEquals("INVALID_ACCOUNT", exception1.getErrorCode());
        
        // Invalid withdrawal amount
        InvalidAccountException exception2 = assertThrows(InvalidAccountException.class,
                                                         () -> ExceptionHandling.withdrawMoney(1000.0, -50.0));
        assertTrue(exception2.getMessage().contains("positive"));
        
        // Insufficient funds
        InsufficientFundsException exception3 = assertThrows(InsufficientFundsException.class,
                                                            () -> ExceptionHandling.withdrawMoney(100.0, 150.0));
        assertEquals(100.0, exception3.getAvailableBalance(), 0.001);
        assertEquals(150.0, exception3.getRequestedAmount(), 0.001);
        assertEquals("INSUFFICIENT_FUNDS", exception3.getErrorCode());
    }
    
    @Test
    void processUserDataHandlesExceptionChaining() {
        // Valid data should not throw
        assertDoesNotThrow(() -> ExceptionHandling.processUserData("user,500.0"));
        
        // Empty data
        BankException exception1 = assertThrows(BankException.class,
                                               () -> ExceptionHandling.processUserData(""));
        assertEquals("TRANSACTION_ERROR", exception1.getErrorCode());
        
        // Invalid format
        BankException exception2 = assertThrows(BankException.class,
                                               () -> ExceptionHandling.processUserData("user"));
        assertEquals("TRANSACTION_ERROR", exception2.getErrorCode());
        
        // Invalid number
        BankException exception3 = assertThrows(BankException.class,
                                               () -> ExceptionHandling.processUserData("user,invalid"));
        assertEquals("PARSE_ERROR", exception3.getErrorCode());
        assertNotNull(exception3.getCause());
        assertTrue(exception3.getCause() instanceof NumberFormatException);
        
        // Insufficient funds
        BankException exception4 = assertThrows(BankException.class,
                                               () -> ExceptionHandling.processUserData("user,2000.0"));
        assertEquals("TRANSACTION_ERROR", exception4.getErrorCode());
        assertTrue(exception4.getCause() instanceof InsufficientFundsException);
    }
    
    @Test
    void safeOperationHandlesCatchUnion() {
        // Invalid input (NumberFormatException)
        String result1 = ExceptionHandling.safeOperation("invalid");
        assertTrue(result1.contains("NumberFormatException"));
        
        // Valid number but will cause ArrayIndexOutOfBoundsException
        String result2 = ExceptionHandling.safeOperation("123");
        assertTrue(result2.contains("ArrayIndexOutOfBoundsException"));
    }
    
    @Test
    void performCriticalOperationRethrowsExceptions() {
        // Normal operation should not throw
        assertDoesNotThrow(() -> ExceptionHandling.performCriticalOperation("user,100.0"));
        
        // Critical error should rethrow as BankException
        BankException exception = assertThrows(BankException.class,
                                              () -> ExceptionHandling.performCriticalOperation("CRITICAL_ERROR_test"));
        assertEquals("CRITICAL_ERROR", exception.getErrorCode());
        assertTrue(exception.getCause() instanceof RuntimeException);
        
        tearDown();
        String errorOutput = errorStream.toString();
        assertTrue(errorOutput.contains("Critical error logged"));
    }
    
    @Test
    void robustDataProcessorHandlesErrors() {
        // Valid data
        String[] validData = {"1", "2", "3", "4"};
        Map<String, Object> result = ExceptionHandling.robustDataProcessor(validData);
        
        assertTrue((Boolean) result.get("success"));
        assertEquals(4, result.get("processed"));
        assertTrue(((List<?>) result.get("errors")).isEmpty());
        
        // Mixed valid and invalid data
        String[] mixedData = {"1", "invalid", "3", null, "-5"};
        result = ExceptionHandling.robustDataProcessor(mixedData);
        
        assertFalse((Boolean) result.get("success"));
        assertEquals(2, result.get("processed")); // "1" and "3" are valid
        
        List<String> errors = (List<String>) result.get("errors");
        assertFalse(errors.isEmpty());
        
        // Check specific error messages
        boolean hasNumberFormatError = errors.stream().anyMatch(e -> e.contains("Invalid number"));
        boolean hasNullError = errors.stream().anyMatch(e -> e.contains("Null element"));
        boolean hasNegativeError = errors.stream().anyMatch(e -> e.contains("Negative value"));
        
        assertTrue(hasNumberFormatError);
        assertTrue(hasNullError);
        assertTrue(hasNegativeError);
        
        // Null input
        result = ExceptionHandling.robustDataProcessor(null);
        assertFalse((Boolean) result.get("success"));
        assertEquals(0, result.get("processed"));
        errors = (List<String>) result.get("errors");
        assertTrue(errors.contains("Input array is null"));
    }
    
    @Test
    void customExceptionHierarchyWorks() {
        // Test BankException hierarchy
        BankException bankException = new BankException("Test message", "TEST_CODE");
        assertEquals("Test message", bankException.getMessage());
        assertEquals("TEST_CODE", bankException.getErrorCode());
        
        // Test InsufficientFundsException
        InsufficientFundsException fundsException = new InsufficientFundsException(100.0, 150.0);
        assertTrue(fundsException instanceof BankException);
        assertEquals("INSUFFICIENT_FUNDS", fundsException.getErrorCode());
        assertEquals(100.0, fundsException.getAvailableBalance(), 0.001);
        assertEquals(150.0, fundsException.getRequestedAmount(), 0.001);
        
        // Test InvalidAccountException
        InvalidAccountException accountException = new InvalidAccountException("Test invalid account");
        assertTrue(accountException instanceof BankException);
        assertEquals("INVALID_ACCOUNT", accountException.getErrorCode());
        assertEquals("Test invalid account", accountException.getMessage());
    }
    
    @Test
    void fileOperationsWithTempFile() throws IOException {
        // Create a temporary file for testing
        Path tempFile = Files.createTempFile("test", ".txt");
        try {
            // Write content to temp file
            Files.write(tempFile, Arrays.asList("Line 1", "Line 2", "Line 3"));
            
            // Test reading with traditional try-catch-finally
            String content1 = ExceptionHandling.readFileContent(tempFile.toString());
            assertFalse(content1.startsWith("Error:"));
            assertTrue(content1.contains("Line 1"));
            assertTrue(content1.contains("Line 2"));
            assertTrue(content1.contains("Line 3"));
            
            // Test reading with try-with-resources
            String content2 = ExceptionHandling.readFileWithResources(tempFile.toString());
            assertFalse(content2.startsWith("Error:"));
            assertTrue(content2.contains("Line 1"));
            assertTrue(content2.contains("Line 2"));
            assertTrue(content2.contains("Line 3"));
            
        } finally {
            // Clean up temp file
            Files.deleteIfExists(tempFile);
        }
    }
}