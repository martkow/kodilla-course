package com.kodilla.kodilla.good.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    public AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }
}
