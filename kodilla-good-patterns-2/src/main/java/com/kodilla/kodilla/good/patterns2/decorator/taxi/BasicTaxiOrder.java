package com.kodilla.kodilla.good.patterns2.decorator.taxi;

import java.math.BigDecimal;

/**
 * In the Decorator pattern, we often refer to such a basic class as the "delegate" of the pattern.
 */
public class BasicTaxiOrder implements TaxiOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(5);
    }

    @Override
    public String getDescription() {
        return "Drive a course.";
    }
}
