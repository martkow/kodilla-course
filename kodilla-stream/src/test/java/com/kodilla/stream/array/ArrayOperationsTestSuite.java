package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for ArrayOperations interface")
public class ArrayOperationsTestSuite {
    @DisplayName("Test for getAverage method for empty array")
    @Test
    void testCaseForGetAverageMethodForEmptyArray() {
        // Given
        int[] numbers = new int[0];
        // When
        double result = ArrayOperations.getAverage(numbers);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test for getAverage method for not empty array")
    @Test
    void testCaseForGetAverageMethodForNonemptyArray() {
        // Given
        int[] numbers = new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 20, 19, 18, 17, 16, 15 ,14, 13, 12, 11};
        // When
        double result = ArrayOperations.getAverage(numbers);
        // Then
        Assertions.assertEquals(15.5, result);
    }
}
