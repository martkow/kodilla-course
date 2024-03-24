package com.kodilla.good.patterns.challenges.solid.order.order;

import com.kodilla.good.patterns.challenges.solid.order.request.ProductOrderRequest;

public class ProductOrderServiceImpl implements ProductOrderService {
    @Override
    public boolean order(ProductOrderRequest productOrderRequest) {
        if (productOrderRequest.getProduct().isInStock() &&
                productOrderRequest.getQuantity() <= productOrderRequest.getProduct().getQuantity()) {
            productOrderRequest.getProduct().setQuantity(productOrderRequest.getQuantity());
            return true;
        }
        return false;
    }
}
