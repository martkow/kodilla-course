package com.kodilla.kodilla.good.patterns2.aop.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@DisplayName("Tests for Calculator class")
@SpringBootTest
public class CalculatorTests {
    private static Logger LOGGER = LoggerFactory.getLogger(CalculatorTests.class);
    @Autowired
    private Calculator calculator;

    @DisplayName("Test case for add method")
    @Test
    void shouldReturnSum() {
        // Given
        // When
        double result = calculator.add(1.0, 2.5);
        // Then
        LOGGER.info("Testing add method.");
        Assertions.assertEquals(3.5, result);
    }

    @DisplayName("Test case for sub method")
    @Test
    void shouldReturnSubtraction() {
        // Given
        // When
        double result = calculator.sub(1.0, 2.5);
        // Then
        LOGGER.info("Testing sub method.");
        Assertions.assertEquals(-1.5, result);
    }

    @DisplayName("Test case for mul method")
    @Test
    void shouldReturnMultiplication() {
        // Given
        // When
        double result = calculator.mul(2.0, 2.5);
        // Then
        LOGGER.info("Testing mul method.");
        Assertions.assertEquals(5, result);
    }

    @DisplayName("Test case for div method")
    @Test
    void shouldReturnDivision() {
        // Given
        // When
        double result = calculator.div(1.0, 2.5);
        // Then
        LOGGER.info("Testing div method.");
        Assertions.assertEquals(0.4, result);
    }

    @DisplayName("Test case for div method")
    @Test
    void shouldReturnArithmeticException() {
        // Given
        // When
        Executable result = () -> calculator.div(1.0, 0);
        // Then
        LOGGER.info("Testing div method with exception.");
        Assertions.assertThrows(ArithmeticException.class, result);
    }

    @DisplayName("Test case for factorial method.")
    @Test
    void shouldReturnFactorial() {
        // Given
        // When
        BigDecimal result = calculator.factorial(5);
        // Then
        LOGGER.info("Testing factorial method");
        Assertions.assertEquals(new BigDecimal(120), result);
    }
}
