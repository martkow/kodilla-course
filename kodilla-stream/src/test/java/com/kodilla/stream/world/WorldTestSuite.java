package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@DisplayName("Tests for World class")
public class WorldTestSuite {
    @DisplayName("Test case for getPeopleQuantity method")
    @Test
    void testCaseForGetPeopleQuantityMethod() {
        // Given
        World world = new World();
        // When
        BigDecimal result = world.getPeopleQuantity();
        // Then
        Assertions.assertEquals(new BigDecimal(3600), result);
    }
}
