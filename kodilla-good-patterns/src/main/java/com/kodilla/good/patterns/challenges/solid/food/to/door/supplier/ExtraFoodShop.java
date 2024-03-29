package com.kodilla.good.patterns.challenges.solid.food.to.door.supplier;

import com.kodilla.good.patterns.challenges.solid.food.to.door.order.OrderRequest;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements Supplier {
    private String name;

    public ExtraFoodShop(String name) {
        this.name = name;
    }

    @Override
    public OrderRequest retrieve() {
        return new OrderRequest(this, new ArrayList<>(List.of("A-1", "B-2")));
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        return true;
    }
}
