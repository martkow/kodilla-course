package com.kodilla.good.patterns.challenges.solid.product.order.order.request;

import com.kodilla.good.patterns.challenges.solid.product.order.product.Product;
import com.kodilla.good.patterns.challenges.solid.product.order.user.User;

import java.time.LocalDateTime;

public class ProductOrderRetriever {
    public ProductOrderRequest retrieve() {
        User user = new User("bubu", "bubu@bubu.com");

        Product product = new Product(111, true, 100);
        long quantity = 10;

        LocalDateTime orderDateTime = LocalDateTime.of(2024, 3, 24, 8, 18, 0);

        return new ProductOrderRequest(user, product, quantity, orderDateTime);
    }
}
