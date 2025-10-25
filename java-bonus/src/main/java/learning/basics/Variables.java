package learning.basics;

public class Variables {
    
    /**
     * Demonstrates primitive data types and their ranges
     */
    public static void demonstrateDataTypes() {
        // Integer types
        byte smallByte = 127;           // -128 to 127
        short smallInt = 32767;         // -32,768 to 32,767
        int regularInt = 2147483647;    // -2^31 to 2^31-1
        long bigInt = 9223372036854775807L; // -2^63 to 2^63-1
        
        // Floating point types
        float smallFloat = 3.14f;       // ~7 decimal digits
        double bigFloat = 3.141592653589793; // ~15-17 decimal digits
        
        // Character and boolean
        char letter = 'A';              // Unicode character
        boolean isTrue = true;          // true or false
    }
    
    /**
     * Calculates area of a rectangle
     */
    public static double rectangleArea(double length, double width) {
        return length * width;
    }
    
    /**
     * Converts temperature from Celsius to Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    
    /**
     * Demonstrates type casting and conversion
     */
    public static int doubleToInt(double value) {
        return (int) value; // Explicit casting - truncates decimal
    }
    
    /**
     * Calculates compound interest
     */
    public static double compoundInterest(double principal, double rate, int years) {
        return principal * Math.pow(1 + rate / 100, years);
    }
    
    /**
     * Constants example - final variables
     */
    public static final double PI = 3.141592653589793;
    public static final int DAYS_IN_WEEK = 7;
    
    /**
     * Calculates circle area using constant
     */
    public static double circleArea(double radius) {
        return PI * radius * radius;
    }
}