package com.kodilla.good.patterns.challenges.solid.food.to.door.supplier.product;

public class Product {
    private final String name;
    private final long quantity;

    public Product(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
