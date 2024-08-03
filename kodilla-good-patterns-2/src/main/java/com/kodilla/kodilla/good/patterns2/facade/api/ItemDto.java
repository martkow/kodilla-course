package com.kodilla.kodilla.good.patterns2.facade.api;

/**
 * Next, define a transport class for the order item – ItemDto:
 */
public final class ItemDto {
    private final Long productId;
    private final double quantity;

    public ItemDto(final Long productId, final double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQuantity() {
        return quantity;
    }
}

