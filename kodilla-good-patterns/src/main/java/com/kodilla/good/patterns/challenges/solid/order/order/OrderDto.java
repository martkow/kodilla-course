package com.kodilla.good.patterns.challenges.solid.order.order;

import com.kodilla.good.patterns.challenges.solid.user.User;

// data transfer object for order
public class OrderDto {
    private User user;
    private boolean orderPlaced;

    public OrderDto(User user, boolean orderPlaced) {
        this.user = user;
        this.orderPlaced = orderPlaced;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }
}
