package com.kodilla.good.patterns.challenges.solid.food.to.door.service;

public class OrderRejectedException extends Exception {
    public OrderRejectedException(String message) {
        super(message);
    }
}
