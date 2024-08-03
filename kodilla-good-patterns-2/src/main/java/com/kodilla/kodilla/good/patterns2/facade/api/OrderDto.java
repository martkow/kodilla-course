package com.kodilla.kodilla.good.patterns2.facade.api;

import java.util.ArrayList;
import java.util.List;

/**
 * The next class is the transport class for the order – OrderDto:
 */
public final class OrderDto {
    private final List<ItemDto> items = new ArrayList<>();

    public void addItem(final ItemDto item) {
        items.add(item);
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
