package com.kodilla.stream.invoice.simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleInvoice {
    private List<SimpleItem> items = new ArrayList<>();

    public void addItem(SimpleItem simpleItem) {
        items.add(simpleItem);
    }

    public boolean removeItem(SimpleItem simpleItem) {
        return items.remove(simpleItem);
    }

    public double getValueToPay() {
        return items.stream()
                .map(SimpleItem::getValue)
                .reduce(0.0, Double::sum);
    }
}
