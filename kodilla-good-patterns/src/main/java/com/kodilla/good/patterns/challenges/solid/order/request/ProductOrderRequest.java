package com.kodilla.good.patterns.challenges.solid.order.request;

import com.kodilla.good.patterns.challenges.solid.product.Product;
import com.kodilla.good.patterns.challenges.solid.user.User;

import java.time.LocalDateTime;

public class ProductOrderRequest {
    private User user;
    private Product product;
    private long quantity;
    private LocalDateTime orderDateTime;

    public ProductOrderRequest(User user, Product product, long quantity, LocalDateTime orderDateTime) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderDateTime = orderDateTime;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public long getQuantity() {
        return quantity;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }
}
