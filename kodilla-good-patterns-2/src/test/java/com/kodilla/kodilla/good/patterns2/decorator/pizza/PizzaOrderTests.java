package com.kodilla.kodilla.good.patterns2.decorator.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@DisplayName("Tests for PizzaOrder interface")
public class PizzaOrderTests {
    @DisplayName("Test case for getDescription method for BasicPizzaOrder with 3 AdditionalIngredientDecorator")
    @Test
    void shouldReturnBasicPizzaWithThreeAdditionalIngredientsOrderDescription() {
        // Given
        PizzaOrder pizzaOrder = new AdditionalIngredientDecorator(IngredientEnum.BASIL, new AdditionalIngredientDecorator(
                IngredientEnum.OLIVES, new AdditionalIngredientDecorator(
                        IngredientEnum.HAM, new BasicPizzaOrder())));
        // When
        String result = pizzaOrder.getDescription();
        // Then
        Assertions.assertEquals("Pizza with cheese and tomato sauce. Additional HAM. Additional OLIVES. Additional BASIL.", result);
    }

    @DisplayName("Test case for getCost method for BasicPizzaOrder with 3 AdditionalIngredientDecorator")
    @Test
    void shouldReturnBasicPizzaWithThreeAdditionalIngredientsOrderCost() {
        // Given
        PizzaOrder pizzaOrder = new AdditionalIngredientDecorator(IngredientEnum.BASIL, new AdditionalIngredientDecorator(
                IngredientEnum.OLIVES, new AdditionalIngredientDecorator(
                IngredientEnum.HAM, new BasicPizzaOrder())));
        // When
        BigDecimal result = pizzaOrder.getCost();
        // Then
        Assertions.assertEquals(new BigDecimal(32), result);
    }
}
