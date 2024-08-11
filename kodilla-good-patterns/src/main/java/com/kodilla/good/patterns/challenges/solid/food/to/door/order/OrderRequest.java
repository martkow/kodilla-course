package com.kodilla.good.patterns.challenges.solid.food.to.door.order;

import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.Supplier;
import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.product.Product;

import java.util.List;

public class OrderRequest {
    private static long idCount = 0;
    private Supplier supplier;
    private long orderRequestId;
    private List<Product> productsList;

    public OrderRequest(Supplier supplier, List<Product> productsList) {
        this.supplier = supplier;
        this.productsList = productsList;
        this.orderRequestId = ++idCount;
    }

    public long getOrderRequestId() {
        return orderRequestId;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "supplier=" + supplier +
                ", orderRequestId=" + orderRequestId +
                ", productsList=" + productsList +
                '}';
    }
}
