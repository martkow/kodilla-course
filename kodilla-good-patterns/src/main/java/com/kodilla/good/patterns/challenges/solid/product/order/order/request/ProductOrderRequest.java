package com.kodilla.good.patterns.challenges.solid.product.order.order.request;

import com.kodilla.good.patterns.challenges.solid.product.order.product.Product;
import com.kodilla.good.patterns.challenges.solid.product.order.user.User;

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
