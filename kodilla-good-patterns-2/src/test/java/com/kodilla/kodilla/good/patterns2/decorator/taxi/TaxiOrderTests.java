package com.kodilla.kodilla.good.patterns2.decorator.taxi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@DisplayName("Tests for TaxiOrder interface")
public class TaxiOrderTests {
    @DisplayName("Test case for getDescription method")
    @Test
    void shouldReturnBasicTaxiOrderDescription() {
        // Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        // When
        String result = taxiOrder.getDescription();
        // Then
        Assertions.assertEquals("Drive a course.", result);
    }

    @DisplayName("Test case for getCost method")
    @Test
    void shouldReturnBasicTaxiOrderCost() {
        // Given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        // When
        BigDecimal result = taxiOrder.getCost();
        // Then
        Assertions.assertEquals(new BigDecimal(5), result);
    }

    @DisplayName("Test case for getDescription method for TaxiNetworkOrderDecorator")
    @Test
    void shouldReturnTaxiNetworkOrderDescription() {
        // Given
        TaxiOrder taxiOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        // When
        String result = taxiOrder.getDescription();
        // Then
        Assertions.assertEquals("Drive a course. By Taxi Network.", result);
    }

    @DisplayName("Test case for getCost method for TaxiNetworkOrderDecorator")
    @Test
    void shouldReturnTaxiNetworkOrderCost() {
        // Given
        TaxiOrder taxiOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        // When
        BigDecimal result = taxiOrder.getCost();
        // Then
        Assertions.assertEquals(new BigDecimal(40), result);
    }

    @DisplayName("Test case for getDescription method for MyyTaxiNetworkOrderDecorator with ChildSeatDecorator")
    @Test
    void shouldReturnMyTaxiNetworkWithChildSeatOrderDescription() {
        // Given
        TaxiOrder taxiOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        // When
        String result = taxiOrder.getDescription();
        // Then
        Assertions.assertEquals("Drive a course. By MyTaxi Network. + Child seat.", result);
    }

    @DisplayName("Test case for getCost method for MyTaxiNetworkOrderDecorator with ChildSeatDecorator")
    @Test
    void shouldReturnMyTaxiNetworkWithChildSeatOrderCost() {
        // Given
        TaxiOrder taxiOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        // When
        BigDecimal result = taxiOrder.getCost();
        // Then
        Assertions.assertEquals(new BigDecimal(37), result);
    }

    @DisplayName("Test case for getDescription method for MyTaxiNetworkOrderDecorator with two ChildSeatDecorator")
    @Test
    void shouldReturnMyTaxiNetworkWithTwoChildSeatOrderDescription() {
        // Given
        TaxiOrder taxiOrder = new ChildSeatDecorator(new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder())));
        // When
        String result = taxiOrder.getDescription();
        // Then
        Assertions.assertEquals("Drive a course. By MyTaxi Network. + Child seat. + Child seat.", result);
    }

    @DisplayName("Test case for getDescription method for TaxiNetworkOrderDecorator with ExpressDecorator, ChildSeatDecorator and VipDecorator")
    @Test
    void shouldReturnTaxiNetworkWithExpressWithChildSeatWithVipOrderDescription() {
        // Given
        TaxiOrder taxiOrder = new VipDecorator(new ChildSeatDecorator(new ExpressDecorator(new TaxiNetworkOrderDecorator(new BasicTaxiOrder()))));
        // When
        String result = taxiOrder.getDescription();
        // Then
        Assertions.assertEquals("Drive a course. By Taxi Network. + Express. + Child seat. + VIP.", result);
    }
}

