package learning.basics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VariablesTest {
    
    @Test
    void rectangleAreaCalculatesCorrectly() {
        assertEquals(20.0, Variables.rectangleArea(4.0, 5.0), 0.001);
        assertEquals(12.5, Variables.rectangleArea(2.5, 5.0), 0.001);
        assertEquals(0.0, Variables.rectangleArea(0.0, 5.0), 0.001);
    }
    
    @Test
    void celsiusToFahrenheitConvertsCorrectly() {
        assertEquals(32.0, Variables.celsiusToFahrenheit(0.0), 0.001);
        assertEquals(212.0, Variables.celsiusToFahrenheit(100.0), 0.001);
        assertEquals(68.0, Variables.celsiusToFahrenheit(20.0), 0.001);
        assertEquals(-40.0, Variables.celsiusToFahrenheit(-40.0), 0.001);
    }
    
    @Test
    void doubleToIntCastsCorrectly() {
        assertEquals(5, Variables.doubleToInt(5.7));
        assertEquals(-3, Variables.doubleToInt(-3.9));
        assertEquals(0, Variables.doubleToInt(0.1));
        assertEquals(42, Variables.doubleToInt(42.0));
    }
    
    @Test
    void compoundInterestCalculatesCorrectly() {
        // $1000 at 5% for 2 years should be $1102.50
        double result = Variables.compoundInterest(1000.0, 5.0, 2);
        assertEquals(1102.5, result, 0.01);
        
        // $500 at 10% for 3 years
        result = Variables.compoundInterest(500.0, 10.0, 3);
        assertEquals(665.5, result, 0.1);
    }
    
    @Test
    void circleAreaUsesConstant() {
        double radius = 2.0;
        double expected = Variables.PI * radius * radius;
        assertEquals(expected, Variables.circleArea(radius), 0.001);
        
        // Test with radius 1 to verify PI is used
        assertEquals(Variables.PI, Variables.circleArea(1.0), 0.001);
    }
    
    @Test
    void constantsHaveCorrectValues() {
        assertEquals(3.141592653589793, Variables.PI, 0.000000000000001);
        assertEquals(7, Variables.DAYS_IN_WEEK);
    }
}