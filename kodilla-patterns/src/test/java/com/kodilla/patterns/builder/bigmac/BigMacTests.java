package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for BigMac class")
public class BigMacTests {
    @DisplayName("Test case for BigMacBuilder class: No bun, Zero burgers ,no sauce, no ingredients")
    @Test
    void testCaseForBigMacBuilderClassNoBurger() {
        // Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .build();
        // When & Then
        System.out.println(bigMac);
    }

    @DisplayName("Test case for BigMacBuilder class")
    @Test
    void testCaseForBigMacBuilderClass() {
        // Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun(Bun.SESAME)
                .burgers((byte) 2)
                .sauce(Sauce.MAYONNAISE)
                .sauce(Sauce.MUSTARD)
                .ingredients(Ingredient.HABANERO)
                .ingredients(Ingredient.BACON)
                .build();
        // When & Then
        System.out.println(bigMac);
    }
}
