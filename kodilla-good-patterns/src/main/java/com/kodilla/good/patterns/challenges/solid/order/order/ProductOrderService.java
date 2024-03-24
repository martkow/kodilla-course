package com.kodilla.good.patterns.challenges.solid.order.order;

import com.kodilla.good.patterns.challenges.solid.order.request.ProductOrderRequest;

public interface ProductOrderService {
    boolean order(ProductOrderRequest productOrderRequest);
}
