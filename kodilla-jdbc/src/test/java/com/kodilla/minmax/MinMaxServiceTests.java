package com.kodilla.minmax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DisplayName("Tests for MinMaxService class")
public class MinMaxServiceTests {
    @DisplayName("Test case for getMin method for empty collection")
    @Test
    void testCaseForGetMinMethodForEmptyCollection() {
        // Given
        Collection<Integer> collection = new ArrayList<>();
        // When
        Integer result = MinMaxService.getMin(collection);
        // Then
        Assertions.assertNull(result);
    }

    @DisplayName("Test case for getMin method for not empty collection with equal elements")
    @Test
    void testCaseForGetMinMethodForEqualElements() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(0, 0, 0));
        // When
        Integer result = MinMaxService.getMin(collection);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test case for getMin method for not empty collection containing extreme values for int")
    @Test
    void testCaseForGetMinMethodContainingExtremes() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(0, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // When
        Integer result = MinMaxService.getMin(collection);
        // Then
        Assertions.assertEquals(Integer.MIN_VALUE, result);
    }

    @DisplayName("Test case for getMin method for not empty regular collection")
    @Test
    void testCaseForGetMinMethod() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(-10, 0, 20));
        // When
        Integer result = MinMaxService.getMin(collection);
        // Then
        Assertions.assertEquals(-10, result);
    }

    @DisplayName("Test case for getMax method for empty collection")
    @Test
    void testCaseForGetMaxMethodForEmptyCollection() {
        // Given
        Collection<Integer> collection = new ArrayList<>();
        // When
        Integer result = MinMaxService.getMax(collection);
        // Then
        Assertions.assertNull(result);
    }

    @DisplayName("Test case for getMax method for not empty collection with equal elements")
    @Test
    void testCaseForGetMaxMethodForEqualElements() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(0, 0, 0));
        // When
        Integer result = MinMaxService.getMax(collection);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test case for getMax method for not empty collection containing extreme values for int")
    @Test
    void testCaseForGetMaxMethodContainingExtremes() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(0, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // When
        Integer result = MinMaxService.getMax(collection);
        // Then
        Assertions.assertEquals(Integer.MAX_VALUE, result);
    }

    @DisplayName("Test case for getMin method for not empty regular collection")
    @Test
    void testCaseForGetMaxMethod() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(-10, 0, 20));
        // When
        Integer result = MinMaxService.getMax(collection);
        // Then
        Assertions.assertEquals(20, result);
    }
}
