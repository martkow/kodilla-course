package com.kodilla.kodilla.good.patterns2.decorator.taxi;

import java.math.BigDecimal;

/**
 * The base class (the one being decorated) is called the delegate, while the decorating class is referred to as the decorator.<br>
 *
 * The decorator is an abstract class, serving as a "base" for extension by concrete decorators. The decorator implements the same interface as the delegate. It "wraps" the delegate class and its methods with its own, adding its own functionality to the delegate's functionality. In other words, it "decorates" the delegate's functionality with its own additions.
 */
public class AbstractTaxiOrderDecorator implements TaxiOrder {
    private final TaxiOrder taxiOrder;

    public AbstractTaxiOrderDecorator(TaxiOrder taxiOrder) {
        this.taxiOrder = taxiOrder;
    }

    @Override
    public BigDecimal getCost() {
        return taxiOrder.getCost();
    }

    @Override
    public String getDescription() {
        return taxiOrder.getDescription();
    }
}
