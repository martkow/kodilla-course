package com.kodilla.patterns.strategy.investment;

import com.kodilla.patterns.strategy.investment.AggressivePredictor;
import com.kodilla.patterns.strategy.investment.Customer;

public final class IndividualYoungCustomer extends Customer {
    public IndividualYoungCustomer(String name) {
        super(name);
        super.buyPredictor = new AggressivePredictor();
    }
}
