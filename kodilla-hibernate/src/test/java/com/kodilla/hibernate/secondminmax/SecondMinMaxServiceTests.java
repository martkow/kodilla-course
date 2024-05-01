package com.kodilla.hibernate.secondminmax;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DisplayName("Tests for SecondMinMaxService class")
public class SecondMinMaxServiceTests {
    @DisplayName("Test case for getSecondMin method for empty collection")
    @Test
    void testCaseForGetSecondMinMethodForEmptyCollection() {
        // Given
        Collection<Integer> collection = new ArrayList<>();
        // When
        Integer result = SecondMinMaxService.getSecondMin(collection);
        // Then
        Assertions.assertNull(result);
    }

    @DisplayName("Test case for getSecondMin method for not empty collection with equal elements")
    @Test
    void testCaseForGetSecondMinMethodForEqualElements() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(0));
        // When
        Integer result = SecondMinMaxService.getSecondMin(collection);
        // Then
        Assertions.assertNull(result);
    }

    @DisplayName("Test case for getSecondMin method for not empty collection containing extreme values for int")
    @Test
    void testCaseForGetSecondMinMethodContainingExtremes() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(0, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE));
        // When
        Integer result = SecondMinMaxService.getSecondMin(collection);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test case for getSecondMin method for not empty regular collection")
    @Test
    void testCaseForGetSecondMinMethod() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(-10, -10, 0, 0, 20));
        // When
        Integer result = SecondMinMaxService.getSecondMin(collection);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test case for getSecondMax method for empty collection")
    @Test
    void testCaseForGetSecondMaxMethodForEmptyCollection() {
        // Given
        Collection<Integer> collection = new ArrayList<>();
        // When
        Integer result = SecondMinMaxService.getSecondMax(collection);
        // Then
        Assertions.assertNull(result);
    }

    @DisplayName("Test case for getSecondMax method for not empty collection with equal elements")
    @Test
    void testCaseForGetSecondMaxMethodForEqualElements() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(0, 0, 0));
        // When
        Integer result = SecondMinMaxService.getSecondMax(collection);
        // Then
        Assertions.assertNull(result);
    }

    @DisplayName("Test case for getSecondMax method for not empty collection containing extreme values for int")
    @Test
    void testCaseForGetSecondMaxMethodContainingExtremes() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(Integer.MAX_VALUE, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // When
        Integer result = SecondMinMaxService.getSecondMax(collection);
        // Then
        Assertions.assertEquals(0, result);
    }

    @DisplayName("Test case for getSecondMax method for not empty regular collection")
    @Test
    void testCaseForGetSecondMaxMethod() {
        // Given
        Collection<Integer> collection = new ArrayList<>(List.of(-10, 0, 20));
        // When
        Integer result = SecondMinMaxService.getSecondMax(collection);
        // Then
        Assertions.assertEquals(0, result);
    }
}
