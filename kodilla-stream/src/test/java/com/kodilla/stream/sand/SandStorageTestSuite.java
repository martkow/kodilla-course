package com.kodilla.stream.sand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Test suite for SandStorage interface")
public class SandStorageTestSuite {
    @DisplayName("Test case for getSandBeansQuantity method")
    @Test
    void testCaseForGetSandBeansQuantityMethod() {
        // Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Africa());
        continents.add(new Asia());
        // When
        BigDecimal result = continents.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        // Then
        Assertions.assertEquals(new BigDecimal("211111110903703703670"), result);
    }
}
