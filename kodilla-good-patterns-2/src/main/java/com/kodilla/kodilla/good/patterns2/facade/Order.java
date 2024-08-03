package com.kodilla.kodilla.good.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Long orderId;
    private final Long userId;
    private boolean paid;
    private boolean verified;
    private boolean submitted;
    private final List<Item> items = new ArrayList<>();
    private final ProductService productService; // Each order stores its own reference to ProductService, but it should be stored globally in the ShopService class.

    public Order(Long orderId, Long userId, ProductService productService) {
        this.orderId = orderId;
        this.userId = userId;
        this.productService = productService;
    }

    public BigDecimal calculateValue() {
        return items.stream()
                .map(i -> new BigDecimal(i.getQty()).multiply(productService.getPrice(i.getProductId())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isVerified() {
        return verified;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}
