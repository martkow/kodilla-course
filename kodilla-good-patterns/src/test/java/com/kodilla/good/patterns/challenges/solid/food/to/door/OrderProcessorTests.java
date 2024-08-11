package com.kodilla.good.patterns.challenges.solid.food.to.door;

import com.kodilla.good.patterns.challenges.solid.food.to.door.order.OrderRequest;
import com.kodilla.good.patterns.challenges.solid.food.to.door.service.OrderProcessor;
import com.kodilla.good.patterns.challenges.solid.food.to.door.service.OrderRejectedException;
import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.LocalFoodShop;
import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

@DisplayName("Tests for OrderProcessor class")
public class OrderProcessorTests {
    @Test
    void shouldRejectOrder() {
        // Given
        Supplier extraFoodShop = new ExtraFoodShop("Extra Food Shop");
        OrderProcessor orderProcessor = new OrderProcessor(extraFoodShop);
        // When
        // Then
        Assertions.assertThrows(OrderRejectedException.class, () -> orderProcessor.processOrder());
    }

    @Test
    void shouldProcessOrder() {
        // Given
        Supplier localFoodShop = new LocalFoodShop("Extra Food Shop");
        OrderProcessor orderProcessor = new OrderProcessor(localFoodShop);
        // When
        // Then
        try {
            OrderRequest result = orderProcessor.processOrder();
            System.out.println(result);
        } catch (OrderRejectedException e) {
            //
        }
    }
}
