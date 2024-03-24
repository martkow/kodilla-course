package com.kodilla.good.patterns.challenges.solid.product.order.order.order;

import com.kodilla.good.patterns.challenges.solid.product.order.order.request.ProductOrderRequest;

public interface ProductOrderService {
    boolean order(ProductOrderRequest productOrderRequest);
}
