package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Logger class")
public class LoggerTestSuite {
    @DisplayName("Test case for getLastLog method")
    @Test
    void testCaseForGetLastLogMethod() {
        // Given
        Logger logger = Logger.INSTANCE;
        logger.log("First log");
        // When
        String result = logger.getLastLog();
        // Then
        Assertions.assertEquals("First log", result);
    }
}
