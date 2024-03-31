package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Tests for Calculator class")
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @DisplayName("Test case for add method")
    @Test
    void testCaseForAddMethod() {
        // Given
        // When
        double result = calculator.add(10, -0.5);
        // Then
        Assertions.assertEquals(9.5, result);
    }

    @DisplayName("Test case for sub method")
    @Test
    void testCaseForSubMethod() {
        // Given
        // When
        double result = calculator.sub(10, -0.5);
        // Then
        Assertions.assertEquals(10.5, result);
    }

    @DisplayName("Test case for mul method")
    @Test
    void testCaseForMulMethod() {
        // Given
        // When
        double result = calculator.mul(10, -0.5);
        // Then
        Assertions.assertEquals(- 5, result);
    }

    @DisplayName("Test case for div method with allowed arguments")
    @Test
    void testCaseForDivMethodWithAllowedArguments() {
        // Given
        // When
        double result = calculator.div(10, -0.5);
        // Then
        Assertions.assertEquals(-20, result);
    }

    @DisplayName("Test case for div method with not allowed arguments")
    @Test
    void testCaseForDivMethodWithNotAllowedArguments() {
        // Given
        // When
        Executable executable = () -> calculator.div(10, 0);
        // Then
        Assertions.assertThrows(IllegalArgumentException.class, executable);
    }
}
