package com.kodilla.kodilla.good.patterns2.decorator.taxi;

import java.math.BigDecimal;

public class ExpressDecorator extends AbstractTaxiOrderDecorator {
    public ExpressDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Express.";
    }
}
