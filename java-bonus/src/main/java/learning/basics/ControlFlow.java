package learning.basics;

public class ControlFlow {
    
    /**
     * Determines grade based on score using if-else statements
     */
    public static char calculateGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    /**
     * Determines if a year is a leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Finds the maximum of three numbers
     */
    public static int maxOfThree(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= c) {
            return b;
        } else {
            return c;
        }
    }
    
    /**
     * Calculates factorial using for loop
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Calculates sum of numbers from 1 to n using while loop
     */
    public static int sumToN(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }
    
    /**
     * Prints multiplication table for a given number
     */
    public static String multiplicationTable(int number, int limit) {
        StringBuilder table = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            table.append(String.format("%d x %d = %d", number, i, number * i));
            if (i < limit) {
                table.append("\\n");
            }
        }
        return table.toString();
    }
    
    /**
     * Counts digits in a number using do-while loop
     */
    public static int countDigits(int number) {
        number = Math.abs(number); // Handle negative numbers
        int count = 0;
        do {
            count++;
            number /= 10;
        } while (number > 0);
        return count;
    }
    
    /**
     * Determines day of week using switch statement
     */
    public static String getDayName(int dayNumber) {
        switch (dayNumber) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Invalid day number";
        }
    }
    
    /**
     * Categorizes age group using switch expressions (Java 17+)
     */
    public static String categorizeAge(int age) {
        return switch (age / 10) {
            case 0, 1 -> "Child";
            case 2, 3 -> "Adult";
            case 4, 5 -> "Middle-aged";
            default -> "Senior";
        };
    }
    
    /**
     * Finds first even number in range using break
     */
    public static int findFirstEven(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                return i;
            }
        }
        return -1; // No even number found
    }
    
    /**
     * Sums only odd numbers using continue
     */
    public static int sumOddNumbers(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            sum += i;
        }
        return sum;
    }
    
    /**
     * Checks if a number is prime
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        
        // Check odd divisors up to sqrt(number)
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Generates Fibonacci sequence up to n terms
     */
    public static int[] fibonacciSequence(int n) {
        if (n <= 0) {
            return new int[0];
        }
        if (n == 1) {
            return new int[]{0};
        }
        if (n == 2) {
            return new int[]{0, 1};
        }
        
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        
        return fibonacci;
    }
    
    /**
     * Reverses digits of a number
     */
    public static int reverseNumber(int number) {
        int reversed = 0;
        boolean negative = number < 0;
        number = Math.abs(number);
        
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        
        return negative ? -reversed : reversed;
    }
}