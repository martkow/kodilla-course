package com.kodilla.patterns.strategy.investment;

import com.kodilla.patterns.strategy.investment.ConservativePredictor;
import com.kodilla.patterns.strategy.investment.Customer;

public final class IndividualCustomer extends Customer {
    public IndividualCustomer(String name) {
        super(name);
        super.buyPredictor = new ConservativePredictor();
    }
}
