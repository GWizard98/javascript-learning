package learning.basics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControlFlowTest {
    
    @Test
    void calculateGradeWorksCorrectly() {
        assertEquals('A', ControlFlow.calculateGrade(95));
        assertEquals('B', ControlFlow.calculateGrade(85));
        assertEquals('C', ControlFlow.calculateGrade(75));
        assertEquals('D', ControlFlow.calculateGrade(65));
        assertEquals('F', ControlFlow.calculateGrade(55));
        assertEquals('A', ControlFlow.calculateGrade(90)); // Boundary case
        assertEquals('F', ControlFlow.calculateGrade(0));
    }
    
    @Test
    void isLeapYearWorksCorrectly() {
        assertTrue(ControlFlow.isLeapYear(2020));  // Divisible by 4
        assertFalse(ControlFlow.isLeapYear(1900)); // Divisible by 100 but not 400
        assertTrue(ControlFlow.isLeapYear(2000));  // Divisible by 400
        assertFalse(ControlFlow.isLeapYear(2021)); // Not divisible by 4
        assertTrue(ControlFlow.isLeapYear(2024));  // Divisible by 4
    }
    
    @Test
    void maxOfThreeWorksCorrectly() {
        assertEquals(5, ControlFlow.maxOfThree(3, 5, 2));
        assertEquals(10, ControlFlow.maxOfThree(10, 5, 8));
        assertEquals(7, ControlFlow.maxOfThree(2, 4, 7));
        assertEquals(5, ControlFlow.maxOfThree(5, 5, 3)); // Equal values
        assertEquals(1, ControlFlow.maxOfThree(1, 1, 1)); // All equal
    }
    
    @Test
    void factorialCalculatesCorrectly() {
        assertEquals(1, ControlFlow.factorial(0));
        assertEquals(1, ControlFlow.factorial(1));
        assertEquals(2, ControlFlow.factorial(2));
        assertEquals(6, ControlFlow.factorial(3));
        assertEquals(24, ControlFlow.factorial(4));
        assertEquals(120, ControlFlow.factorial(5));
        
        // Test exception for negative numbers
        assertThrows(IllegalArgumentException.class, () -> ControlFlow.factorial(-1));
    }
    
    @Test
    void sumToNWorksCorrectly() {
        assertEquals(15, ControlFlow.sumToN(5)); // 1+2+3+4+5 = 15
        assertEquals(1, ControlFlow.sumToN(1));
        assertEquals(0, ControlFlow.sumToN(0));
        assertEquals(55, ControlFlow.sumToN(10)); // 1+2+...+10 = 55
    }
    
    @Test
    void multiplicationTableGeneratesCorrectly() {
        String expected = "2 x 1 = 2\\n2 x 2 = 4\\n2 x 3 = 6";
        assertEquals(expected, ControlFlow.multiplicationTable(2, 3));
        
        expected = "5 x 1 = 5";
        assertEquals(expected, ControlFlow.multiplicationTable(5, 1));
    }
    
    @Test
    void countDigitsWorksCorrectly() {
        assertEquals(3, ControlFlow.countDigits(123));
        assertEquals(1, ControlFlow.countDigits(5));
        assertEquals(1, ControlFlow.countDigits(0));
        assertEquals(4, ControlFlow.countDigits(-1234)); // Negative numbers
        assertEquals(5, ControlFlow.countDigits(99999));
    }
    
    @Test
    void getDayNameWorksCorrectly() {
        assertEquals("Monday", ControlFlow.getDayName(1));
        assertEquals("Tuesday", ControlFlow.getDayName(2));
        assertEquals("Wednesday", ControlFlow.getDayName(3));
        assertEquals("Thursday", ControlFlow.getDayName(4));
        assertEquals("Friday", ControlFlow.getDayName(5));
        assertEquals("Saturday", ControlFlow.getDayName(6));
        assertEquals("Sunday", ControlFlow.getDayName(7));
        assertEquals("Invalid day number", ControlFlow.getDayName(0));
        assertEquals("Invalid day number", ControlFlow.getDayName(8));
    }
    
    @Test
    void categorizeAgeWorksCorrectly() {
        assertEquals("Child", ControlFlow.categorizeAge(5));
        assertEquals("Child", ControlFlow.categorizeAge(15));
        assertEquals("Adult", ControlFlow.categorizeAge(25));
        assertEquals("Adult", ControlFlow.categorizeAge(35));
        assertEquals("Middle-aged", ControlFlow.categorizeAge(45));
        assertEquals("Middle-aged", ControlFlow.categorizeAge(55));
        assertEquals("Senior", ControlFlow.categorizeAge(65));
        assertEquals("Senior", ControlFlow.categorizeAge(80));
    }
    
    @Test
    void findFirstEvenWorksCorrectly() {
        assertEquals(2, ControlFlow.findFirstEven(1, 5));
        assertEquals(4, ControlFlow.findFirstEven(3, 7));
        assertEquals(10, ControlFlow.findFirstEven(10, 15));
        assertEquals(2, ControlFlow.findFirstEven(1, 3)); // 2 is even in range 1-3
        assertEquals(-1, ControlFlow.findFirstEven(5, 5)); // Single odd number
    }
    
    @Test
    void sumOddNumbersWorksCorrectly() {
        assertEquals(9, ControlFlow.sumOddNumbers(1, 5)); // 1+3+5 = 9
        assertEquals(15, ControlFlow.sumOddNumbers(3, 7)); // 3+5+7 = 15
        assertEquals(21, ControlFlow.sumOddNumbers(5, 9)); // 5+7+9 = 21
        assertEquals(3, ControlFlow.sumOddNumbers(2, 4)); // Only 3 is odd
    }
    
    @Test
    void isPrimeWorksCorrectly() {
        assertFalse(ControlFlow.isPrime(0));
        assertFalse(ControlFlow.isPrime(1));
        assertTrue(ControlFlow.isPrime(2));
        assertTrue(ControlFlow.isPrime(3));
        assertFalse(ControlFlow.isPrime(4));
        assertTrue(ControlFlow.isPrime(5));
        assertFalse(ControlFlow.isPrime(9));
        assertTrue(ControlFlow.isPrime(11));
        assertTrue(ControlFlow.isPrime(13));
        assertFalse(ControlFlow.isPrime(15));
        assertTrue(ControlFlow.isPrime(17));
        assertFalse(ControlFlow.isPrime(25));
    }
    
    @Test
    void fibonacciSequenceGeneratesCorrectly() {
        assertArrayEquals(new int[]{}, ControlFlow.fibonacciSequence(0));
        assertArrayEquals(new int[]{0}, ControlFlow.fibonacciSequence(1));
        assertArrayEquals(new int[]{0, 1}, ControlFlow.fibonacciSequence(2));
        assertArrayEquals(new int[]{0, 1, 1}, ControlFlow.fibonacciSequence(3));
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, ControlFlow.fibonacciSequence(7));
    }
    
    @Test
    void reverseNumberWorksCorrectly() {
        assertEquals(321, ControlFlow.reverseNumber(123));
        assertEquals(1, ControlFlow.reverseNumber(100));
        assertEquals(0, ControlFlow.reverseNumber(0));
        assertEquals(-456, ControlFlow.reverseNumber(-654));
        assertEquals(9, ControlFlow.reverseNumber(9));
    }
}