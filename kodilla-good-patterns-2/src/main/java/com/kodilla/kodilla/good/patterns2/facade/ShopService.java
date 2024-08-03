package com.kodilla.kodilla.good.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    private final AuthenticationService authenticationService;
    private final ProductService productService;

    @Autowired
    public ShopService(AuthenticationService authenticationService, ProductService productService) {
        this.authenticationService = authenticationService;
        this.productService = productService;
    }

    public Long openOrder(Long userId) {
        if (!authenticationService.isAuthenticated(userId)) {
            return -1L;
        }

        Order newOrder = new Order(
                orders.stream()
                        .map(Order::getOrderId)
                        .max(Comparator.naturalOrder())
                        .orElse(0L) + 1L,
                userId,
                productService
        );
        orders.add(newOrder);

        return newOrder.getOrderId();
    }

    public void addItem(Long orderId, Long productId, double qty) {
        orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .forEach(o -> o.getItems().add(new Item(productId, qty)));
    }

    public boolean removeItem(Long orderId, Long productId) {
        // The method of searching for an order to perform further operations on it is strange (an Iterator is returned, while in principle, there should only be one order with the given identifier).
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();

        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();

            if (order.getItems().removeIf(i -> i.getProductId().equals(productId))) {
                return true;
            }
        }

        return false;
    }

    public BigDecimal calculateValue(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();

        while (orderIterator.hasNext()) {
            return orderIterator.next().calculateValue();
        }

        return BigDecimal.ZERO;
    }

    public boolean doPayment(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();

        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();

            if (order.isPaid()) {
                return true;
            }

            order.setPaid(new Random().nextBoolean());
            return order.isPaid();
        }

        return false;
    }

    public boolean verifyOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();

        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();

            if (order.isVerified()) {
                return true;
            }

            order.setVerified(order.isPaid() && new Random().nextBoolean());
            return order.isVerified();
        }

        return false;
    }

    public boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();

        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();

            if (order.isVerified()) {
                order.setSubmitted(true);
            }

            return order.isSubmitted();
        }

        return false;
    }

    public void cancelOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();

        while (orderIterator.hasNext()) {
            orders.remove(orderIterator.next());
        }
    }
}
