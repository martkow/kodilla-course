package com.kodilla.good.patterns.challenges.solid.product.order.order.repository;

import com.kodilla.good.patterns.challenges.solid.product.order.order.request.ProductOrderRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ProductOrderFileRepository implements ProductOrderRepository {
    private static final String SEPARATOR = ",";
    private static final String NEWLINE = "\n";
    private static final Path path = Paths.get("kodilla-good-patterns/src/main/resources/orders.txt");
    @Override
    public void createOrder(ProductOrderRequest productOrderRequest) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.write(productOrderRequest.getUser().getUserName() + SEPARATOR
                    + productOrderRequest.getOrderDateTime() + SEPARATOR
                    + productOrderRequest.getProduct().getProductNumber() + SEPARATOR
                    + productOrderRequest.getQuantity() + NEWLINE);
        } catch (IOException e) {
            System.out.println("Repository not available: " + e.getMessage());
        }
    }
}
