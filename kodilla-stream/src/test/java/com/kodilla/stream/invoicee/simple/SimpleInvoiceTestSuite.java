package com.kodilla.stream.invoicee.simple;

import com.kodilla.stream.invoice.simple.SimpleInvoice;
import com.kodilla.stream.invoice.simple.SimpleItem;
import com.kodilla.stream.invoice.simple.SimpleProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test suite for SimpleInvoice class")
public class SimpleInvoiceTestSuite {
    @DisplayName("Test case for getValueToPay mathod")
    @Test
    void testCaseForGetValueToPayMethod() {
        // Given
        SimpleItem i1 = new SimpleItem(new SimpleProduct("product1", 17.28), 2.0);
        SimpleItem i2 = new SimpleItem(new SimpleProduct("product2", 11.99), 3.5);
        SimpleItem i3 = new SimpleItem(new SimpleProduct("product3", 6.49), 5.0);
        SimpleInvoice simpleInvoice = new SimpleInvoice();
        simpleInvoice.addItem(i1);
        simpleInvoice.addItem(i2);
        simpleInvoice.addItem(i3);
        // When
        double result = simpleInvoice.getValueToPay();
        // Then
        Assertions.assertEquals(108.975, result, 0.001);
    }
}
