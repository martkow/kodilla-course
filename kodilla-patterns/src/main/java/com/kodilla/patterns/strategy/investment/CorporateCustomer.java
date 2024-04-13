package com.kodilla.patterns.strategy.investment;

public final class CorporateCustomer extends Customer {
    public CorporateCustomer(String name) {
        super(name);
        super.buyPredictor = new BalancedPredictor();
    }
}
