package com.kodilla.good.patterns.challenges.solid.product;

public class Product {
    private long productNumber;
    private String productDescription;
    private String productCondition;
    private boolean inStock;
    private long quantity;
    private long price;

    public Product(long productNumber, boolean inStock, long quantity) {
        this.productNumber = productNumber;
        this.inStock = inStock;
        this.quantity = quantity;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public boolean isInStock() {
        return inStock;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity -= quantity;
    }
}
