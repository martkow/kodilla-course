package com.kodilla.good.patterns.challenges.solid.food.to.door.service;

import com.kodilla.good.patterns.challenges.solid.food.to.door.order.OrderRequest;
import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.Supplier;

public class OrderProcessor {
    Supplier supplier;

    public OrderProcessor(Supplier supplier) {
        this.supplier = supplier;
    }

    public void processOrder() {
        OrderRequest orderRequest = supplier.retrieve();

        if (supplier.process(orderRequest)) {
            System.out.println("Order successfully completed.");
        } else {
            System.out.println("Error");
        }
    }
}
