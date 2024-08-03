package com.kodilla.kodilla.good.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AdditionalIngredientDecorator extends AbstractPizzaOrderDecorator {
    private final IngredientEnum ingredient;

    public AdditionalIngredientDecorator(IngredientEnum ingredient, PizzaOrder pizzaOrder) {
        super(pizzaOrder);
        this.ingredient = ingredient;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Additional " + ingredient.getIngredientDescription() + ".";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(ingredient.getIngredientCost());
    }
}
