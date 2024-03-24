package com.kodilla.good.patterns.challenges.solid;

import com.kodilla.good.patterns.challenges.solid.ntf.EmailService;
import com.kodilla.good.patterns.challenges.solid.order.order.ProductOrderProcessor;
import com.kodilla.good.patterns.challenges.solid.order.order.ProductOrderServiceImpl;
import com.kodilla.good.patterns.challenges.solid.order.repository.FileOrderRepository;
import com.kodilla.good.patterns.challenges.solid.order.request.ProductOrderRequest;
import com.kodilla.good.patterns.challenges.solid.order.request.ProductOrderRetriever;

// core of app - get request and start processing order
public class Application {
    public static void main(String[] args) {
        ProductOrderRetriever productOrderRetriever = new ProductOrderRetriever();
        ProductOrderRequest productOrderRequest = productOrderRetriever.retrieve();

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(
                new EmailService(),
                new ProductOrderServiceImpl(),
                new FileOrderRepository()
        );

        productOrderProcessor.order(productOrderRequest);
    }
}
