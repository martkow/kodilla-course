package com.kodilla.good.patterns.challenges.solid.food.to.door.service;

import com.kodilla.good.patterns.challenges.solid.food.to.door.order.OrderRequest;
import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessor.class);
    private final Supplier supplier;

    public OrderProcessor(Supplier supplier) {
        this.supplier = supplier;
    }

    public OrderRequest processOrder() throws OrderRejectedException {
        OrderRequest orderRequest = supplier.retrieve();

        if (supplier.process(orderRequest)) {
            LOGGER.info("Order id {} processed successfully.", orderRequest.getOrderRequestId());
            return orderRequest;
        } else {
            LOGGER.error("Order id {} rejected.", orderRequest.getOrderRequestId());
            throw new OrderRejectedException("Order rejected");
        }
    }
}
