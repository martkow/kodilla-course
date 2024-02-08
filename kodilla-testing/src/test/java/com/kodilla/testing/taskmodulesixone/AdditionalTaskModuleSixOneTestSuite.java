package com.kodilla.testing.taskmodulesixone;

import org.junit.jupiter.api.*;

@DisplayName("Tests for AdditionalTaskModuleSixOne class")
public class AdditionalTaskModuleSixOneTestSuite {
    @BeforeAll
    static void testsStartInfo() {
        System.out.println("Tests for AdditionalTaskModuleSixOne class");
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

    @DisplayName("Test case for getVowels method")
    @Test
    void testCaseGetVowels() {
        // Given
        String s = "Adam";
        StringBuilder expectedResult = new StringBuilder("Aa");
        // When
        StringBuilder result = AdditionalTaskModuleSixOne.getVowels(s);
        // Then
        Assertions.assertEquals(0, expectedResult.compareTo(result));
    }
}
