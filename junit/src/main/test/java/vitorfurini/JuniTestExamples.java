package vitorfurini;

import org.junit.jupiter.api.Test;
import org.vitorfurini.junit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class JuniTestExamples {

    Calculator calculator = new Calculator();

    // Test addition
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    // Test subtraction
    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
    }

    // Test multiplication
    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    // Test division
    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), "6 / 3 should equal 2.0");
    }

    // Test division by zero
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Division by zero should throw ArithmeticException");
    }

    // Test if the result of addition is not equal to a wrong number
    @Test
    void testAddNotEqual() {
        assertNotEquals(6, calculator.add(2, 3), "2 + 3 should not equal 6");
    }

    // Test assertTrue (to check if a condition is true)
    @Test
    void testIsPositive() {
        assertTrue(calculator.add(2, 3) > 0, "The result of 2 + 3 should be positive");
    }

    // Test assertFalse (to check if a condition is false)
    @Test
    void testIsNegative() {
        assertFalse(calculator.subtract(2, 3) > 0, "The result of 2 - 3 should not be positive");
    }

    // Test assertNull (to check if an object is null)
    @Test
    void testNull() {
        Calculator calc = null;
        assertNull(calc, "Calculator should be null");
    }

    // Test assertNotNull (to check if an object is not null)
    @Test
    void testNotNull() {
        assertNotNull(calculator, "Calculator should not be null");
    }
}
