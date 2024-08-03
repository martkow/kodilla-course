package com.kodilla.kodilla.good.patterns2.decorator.taxi;

import java.math.BigDecimal;

public class TaxiNetworkOrderDecorator extends AbstractTaxiOrderDecorator {

    public TaxiNetworkOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    /**
     * This decorator extends the abstract class AbstractTaxiOrderDecorator, thereby inheriting its properties. The decorator’s methods invoke the methods of the delegate but extend them by adding its own features, information, and functionality.
     */
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(35));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " By Taxi Network.";
    }
}
