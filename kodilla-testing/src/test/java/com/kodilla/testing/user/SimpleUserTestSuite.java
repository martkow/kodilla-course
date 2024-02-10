package com.kodilla.testing.user;

import org.junit.jupiter.api.*;

@DisplayName("Tests for SimpleUser class")
public class SimpleUserTestSuite {

    @BeforeAll
    static void testsStartInfo() {
        System.out.println("Tests for SimpleUser class");
    }

    @AfterAll
    static void testsEndInfo() {
        System.out.println("All tests for SimpleUser class passed");
    }

    @BeforeEach
    void testCaseStartInfo() {
        System.out.println("Test case starts");
    }

    @AfterEach
    void testCaseEndInfo() {
        System.out.println("Test case passed");
    }

    @DisplayName("Test case for getUserName method")
    @Test
    void testCaseGetUserName() {
        // Given
        SimpleUser simpleUser = new SimpleUser("Bubu", "Bubuslaw");
        // When
        String result = simpleUser.getUserName();
        // Then
        Assertions.assertEquals("Bubu", result);
    }

    @DisplayName("Test case for getRealName method")
    @Test
    void testCaseGetRealName() {
        // Given
        SimpleUser simpleUser = new SimpleUser("Bubu", "Bubuslaw");
        // When
        String result = simpleUser.getRealName();
        // Then
        Assertions.assertEquals("Bubuslaw", result);
    }
}