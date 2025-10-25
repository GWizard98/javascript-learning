package learning.exceptions;

/**
 * Custom exception for banking operations
 */
public class BankException extends Exception {
    private String errorCode;
    
    public BankException(String message) {
        super(message);
    }
    
    public BankException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BankException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public BankException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}

/**
 * Specific exception for insufficient funds
 */
class InsufficientFundsException extends BankException {
    private double availableBalance;
    private double requestedAmount;
    
    public InsufficientFundsException(double availableBalance, double requestedAmount) {
        super(String.format("Insufficient funds: Available %.2f, Requested %.2f", 
                           availableBalance, requestedAmount), "INSUFFICIENT_FUNDS");
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
    }
    
    public double getAvailableBalance() {
        return availableBalance;
    }
    
    public double getRequestedAmount() {
        return requestedAmount;
    }
}

/**
 * Exception for invalid account operations
 */
class InvalidAccountException extends BankException {
    public InvalidAccountException(String message) {
        super(message, "INVALID_ACCOUNT");
    }
}