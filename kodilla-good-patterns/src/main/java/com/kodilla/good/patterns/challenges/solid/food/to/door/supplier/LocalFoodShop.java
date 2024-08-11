package com.kodilla.good.patterns.challenges.solid.food.to.door.supplier;

import com.kodilla.good.patterns.challenges.solid.food.to.door.order.OrderRequest;
import com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.product.Product;

import java.util.ArrayList;
import java.util.List;

public class LocalFoodShop implements Supplier {
    private String name;

    public LocalFoodShop(String name) {
        this.name = name;
    }

    @Override
    public OrderRequest retrieve() {
        List<Product> products = new ArrayList<>(List.of(
                new Product("Carrot", 100),
                new Product("Apple", 20)
        ));
        return new OrderRequest(this, products);
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        return true;
    }
}
