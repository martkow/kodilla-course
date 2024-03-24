package com.kodilla.good.patterns.challenges.solid.product.order.order.repository;

import com.kodilla.good.patterns.challenges.solid.product.order.order.request.ProductOrderRequest;

public interface ProductOrderRepository {
    void createOrder(ProductOrderRequest productOrderRequest);
}
