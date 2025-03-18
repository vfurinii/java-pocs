package com.vitorfurini;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.vitorfurini.junit.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssumptionsExampleTests {

    Calculator calculator = new Calculator();

    // Test will only run if the OS is Windows
    @Test
    void testAddOnWindows() {
        // Make an assumption that the OS is Windows
        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Windows"));

        // This test will only execute if the assumption is true (if OS is Windows)
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5 on Windows");
    }

    // Test will only run if the OS is NOT Windows
    @Test
    void testAddNotOnWindows() {
        // Make an assumption that the OS is NOT Windows
        Assumptions.assumeFalse(System.getProperty("os.name").startsWith("Windows"));

        // This test will only execute if the assumption is true (if OS is not Windows)
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5 on non-Windows OS");
    }

    // Test will only run if a certain environment variable is set
    @Test
    void testWithEnvironmentVariable() {
        // Assumption: Only run if the MY_ENV_VAR environment variable is set to 'production'
        Assumptions.assumeTrue("production".equals(System.getenv("MY_ENV_VAR")), "Test skipped because MY_ENV_VAR is not 'production'");

        // This will be executed only if the assumption is true
        assertEquals(10, calculator.multiply(2, 5), "2 * 5 should equal 10 in production environment");
    }

    // Test with assumption on a property
    @Test
    void testAddWithPropertyCheck() {
        // Assuming a system property that determines whether the test should run
        Assumptions.assumeTrue("true".equals(System.getProperty("runTests")), "Test skipped because 'runTests' property is not set to 'true'");

        // This will be executed only if the assumption is true
        assertEquals(8, calculator.add(5, 3), "5 + 3 should equal 8 if 'runTests' property is true");
    }

    // Test with assumption on multiple conditions
    @Test
    void testAddMultipleConditions() {
        // Assumption: Run test only if both conditions are true
        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Linux"), "Test skipped because OS is not Linux");
        Assumptions.assumeTrue("true".equals(System.getProperty("runTests")), "Test skipped because 'runTests' property is not set to 'true'");

        // This test will only run if both assumptions are true
        assertEquals(7, calculator.add(3, 4), "3 + 4 should equal 7 on Linux with 'runTests' property set to 'true'");
    }
}
