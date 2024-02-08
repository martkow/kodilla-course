package com.kodilla.testing.calculator;

import org.junit.jupiter.api.*;

@DisplayName("Tests for Calculator class")
public class CalculatorTestSuite {
    @BeforeAll
    static void testsStartInfo() {
        System.out.println("Tests for Calculator class");
    }

    @AfterAll
    static void testsEndInfo() {
        System.out.println("All tests for Calculator class passed");
    }

    @BeforeEach
    void testCaseStartInfo() {
        System.out.println("Test case starts");
    }

    @AfterEach
    void testCaseEndInfo() {
        System.out.println("Test case passed");
    }

    @DisplayName("Test case for add method")
    @Test
    void testCaseAdd() {
        // Given
        int a = -1;
        int b = 10;
        // When
        int result = Calculator.add(a,b);
        // Then
        Assertions.assertEquals(9, result);
    }

    @DisplayName("Test case for subtract method")
    @Test
    void testCaseSubtract() {
        // Given
        int a = -1;
        int b = 10;
        // When
        int result = Calculator.subtract(a,b);
        // Then
        Assertions.assertEquals(-11, result);
    }
}
