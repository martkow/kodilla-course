package com.kodilla.good.patterns.challenges.solid.order.repository;

import com.kodilla.good.patterns.challenges.solid.order.request.ProductOrderRequest;

public interface ProductOrderRepository {
    void createOrder(ProductOrderRequest productOrderRequest);
}
