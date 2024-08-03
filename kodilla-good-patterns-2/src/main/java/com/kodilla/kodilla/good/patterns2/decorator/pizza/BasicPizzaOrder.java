package com.kodilla.kodilla.good.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public String getDescription() {
        return "Pizza with cheese and tomato sauce.";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(20);
    }
}
