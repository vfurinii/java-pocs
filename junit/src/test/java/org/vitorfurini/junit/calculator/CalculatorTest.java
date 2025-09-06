package org.vitorfurini.junit.calculator;

import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @InjectMocks
    private static Calculator calculator;

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("Starting Calculator Tests");
        calculator = Mockito.mock(Calculator.class);
    }

    @Test
    void add_happy_path() {
        //given
        Mockito.when(calculator.add(2, 3)).thenReturn(5);

        //when
        int result = calculator.add(2, 3);

        //then
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void add_fail_path() {
        //given
        Mockito.when(calculator.add(2, 3)).thenReturn(5);

        //when
        int result = calculator.add(2, 3);

        //then
        assertNotEquals(10, result, "2 + 3 should equal 5");
    }

    @Test
    void subtract() {
        //given
        Mockito.when(calculator.subtract(5, 3)).thenReturn(2);

        //when
        int result = calculator.subtract(5, 3);

        //then
        assertEquals(2, result, "5 - 3 should equal 2");
    }

    @Test
    void multiply() {
        //given
        Mockito.when(calculator.multiply(2, 3)).thenReturn(6);

        //when
        int result = calculator.multiply(2, 3);

        //then
        assertEquals(6, result, "2 * 3 should equal 6");
    }

    @Test
    void divide() {
        //given
        Mockito.when(calculator.divide(6, 3)).thenReturn(2.0);
        Mockito.when(calculator.divide(5, 0)).thenThrow(new ArithmeticException("Cannot divide by zero"));

        //when
        double result = calculator.divide(6, 3);

        //then
        assertEquals(2.0, result, "6 / 3 should equal 2.0");

        //when exception
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });

        //then
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}