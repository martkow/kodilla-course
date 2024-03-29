package com.kodilla.good.patterns.challenges.solid.food.to.door.order;

import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.Supplier;

import java.util.List;

public class OrderRequest {
    private Supplier supplier;
    private List<String> productsList;

    public OrderRequest(Supplier supplier, List<String> productsList) {
        this.supplier = supplier;
        this.productsList = productsList;
    }
}
