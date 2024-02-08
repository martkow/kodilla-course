package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Tests for OddNumbersExterminator class")
public class OddNumbersExterminatorTestSuite {
    @BeforeAll
    static void testsStartInfo() {
        System.out.println("Tests for OddNumbersExterminator class");
    }

    @AfterAll
    static void testsEndInfo() {
        System.out.println("All tests passed");
    }

    @BeforeEach
    void testCaseStartInfo() {
        System.out.println("Test case starts");
    }

    @AfterEach
    void testCaseEndInfo() {
        System.out.println("Test case passed");
    }

    @DisplayName("Test case for exterminate method receiving empty list ")
    @Test
    void testCaseExterminateMethodForEmptyList() {
        // Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> numbers = Arrays.asList();
        // When
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        // Then
        Assertions.assertEquals(Arrays.asList(), result);
    }

    @DisplayName("Test case for exterminate method receiving normal list ")
    @Test
    void testCaseExterminateMethodForNormalList() {
        // Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> numbers = Arrays.asList(-2, -13, -10, -1, 0, 1, 2, 12, 15);
        List<Integer> evenNumbers = Arrays.asList(-2, -10, 0, 2, 12);
        // When
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        // Then
        Assertions.assertEquals(evenNumbers, result);
    }
}
