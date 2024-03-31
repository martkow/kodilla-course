package com.kodilla.spring.portfolio.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Tests for Fibonacci class")
@SpringBootTest
public class FibonacciTestSuite {
    @Autowired
    private Fibonacci fibonacci;

    @DisplayName("Test case for calculateNFibonacciNumber method for n=0")
    @Test
    void testCaseForCalculateNFibonacciNumberForNEqualsZero() {
        // Given
        // When
        int result = fibonacci.calculateNFibonacciNumber(0);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test case for calculateNFibonacciNumber method for n=1")
    @Test
    void testCaseForCalculateNFibonacciNumberForNEqualsOne() {
        // Given
        // When
        int result = fibonacci.calculateNFibonacciNumber(1);
        // Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("Test case for calculateNFibonacciNumber method for n=5")
    @Test
    void testCaseForCalculateNFibonacciNumberForNEqualsFive() {
        // Given
        // When
        int result = fibonacci.calculateNFibonacciNumber(5);
        // Then
        Assertions.assertEquals(5, result);
    }

    @DisplayName("Test case for calculateNFibonacciNumberNoRecursion method for n=0")
    @Test
    void testCaseForCalculateNFibonacciNumberNoRecursionForNEqualsZero() {
        // Given
        // When
        int result = fibonacci.calculateNFibonacciNumberNoRecursion(0);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test case for calculateNFibonacciNumberNoRecursion method for n=1")
    @Test
    void testCaseForCalculateNFibonacciNumberNoRecursionForNEqualsOne() {
        // Given
        // When
        int result = fibonacci.calculateNFibonacciNumberNoRecursion(1);
        // Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("Test case for calculateNFibonacciNumberNoRecursion method for n=10")
    @Test
    void testCaseForCalculateNFibonacciNumberNoRecursionForNEqualsFive() {
        // Given
        // When
        int result = fibonacci.calculateNFibonacciNumberNoRecursion(10);
        // Then
        Assertions.assertEquals(55, result);
    }
}
