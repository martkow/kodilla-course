package com.kodilla.good.patterns.challenges.solid.food.to.door.supplier;

import com.kodilla.good.patterns.challenges.solid.food.to.door.order.OrderRequest;

public interface Supplier {
    OrderRequest retrieve();
    boolean process(OrderRequest orderRequest);
}
