package com.kodilla.patterns.builder.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Pizza class")
public class PizzaTests {
    @DisplayName("Test case for constructor Pizza")
    @Test
    void testCaseForConstructorPizza() {
        // Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .bottom("Italian")
                .sauce("Tomato sauce")
                .ingredient("Salami Piccante")
                .ingredient("Olives")
                .ingredient("Mozzarella")
                .build();
        System.out.println(pizza);
        // When
        int toppingsNumber = pizza.getIngredients().size();
        // Then
        Assertions.assertEquals(3, toppingsNumber);
    }
}
