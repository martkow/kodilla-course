package com.kodilla.good.patterns.challenges.solid.product.order;

import com.kodilla.good.patterns.challenges.solid.product.order.ntf.EmailService;
import com.kodilla.good.patterns.challenges.solid.product.order.order.order.ProductOrderProcessor;
import com.kodilla.good.patterns.challenges.solid.product.order.order.order.ProductOrderServiceImpl;
import com.kodilla.good.patterns.challenges.solid.product.order.order.repository.ProductOrderFileRepository;
import com.kodilla.good.patterns.challenges.solid.product.order.order.request.ProductOrderRequest;
import com.kodilla.good.patterns.challenges.solid.product.order.order.request.ProductOrderRetriever;

// core of app - get request and start processing order
public class Application {
    public static void main(String[] args) {
        ProductOrderRetriever productOrderRetriever = new ProductOrderRetriever();
        ProductOrderRequest productOrderRequest = productOrderRetriever.retrieve();

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(
                new EmailService(),
                new ProductOrderServiceImpl(),
                new ProductOrderFileRepository()
        );

        productOrderProcessor.order(productOrderRequest);
    }
}
