package com.kodilla.kodilla.good.patterns2.decorator.pizza;

import java.math.BigDecimal;

public enum IngredientEnum {
    BASIL, OLIVES, HAM, MUSHROOM;

    public BigDecimal getIngredientCost() {
        return switch (this) {
            case BASIL -> new BigDecimal(3);
            case OLIVES -> new BigDecimal(4);
            case HAM -> new BigDecimal(5);
            case MUSHROOM -> new BigDecimal(4);
        };
    }

    public String getIngredientDescription() {
        return this.toString();
    }
}
