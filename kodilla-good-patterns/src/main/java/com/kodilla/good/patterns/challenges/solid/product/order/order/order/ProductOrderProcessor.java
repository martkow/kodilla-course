package com.kodilla.good.patterns.challenges.solid.product.order.order.order;

import com.kodilla.good.patterns.challenges.solid.product.order.ntf.InformationService;
import com.kodilla.good.patterns.challenges.solid.product.order.order.repository.ProductOrderRepository;
import com.kodilla.good.patterns.challenges.solid.product.order.order.request.ProductOrderRequest;

// to process order - logic of ordering
public class ProductOrderProcessor {
    private InformationService informationService;
    private ProductOrderService productOrderService;
    private ProductOrderRepository productOrderRepository;

    public ProductOrderProcessor(InformationService informationService, ProductOrderService productOrderService, ProductOrderRepository productOrderRepository) {
        this.informationService = informationService;
        this.productOrderService = productOrderService;
        this.productOrderRepository = productOrderRepository;
    }

    public OrderDto order(ProductOrderRequest productOrderRequest) {
        boolean isOrdered = productOrderService.order(productOrderRequest);

        if (isOrdered) {
            productOrderRepository.createOrder(productOrderRequest);
            informationService.inform(productOrderRequest.getUser());
            return new OrderDto(productOrderRequest.getUser(), true);
        }
        return new OrderDto(productOrderRequest.getUser(), false);
    }
}
