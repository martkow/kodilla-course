//package com.kodilla.hibernate.invoice.dao;
//
//import com.kodilla.hibernate.invoice.Invoice;
//import com.kodilla.hibernate.invoice.Item;
//import com.kodilla.hibernate.invoice.Product;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//import java.math.BigDecimal;
//
//@Transactional
//@DisplayName("Tests for InvoiceDao interface - Data Object Access layer -> Repository controller")
//@SpringBootTest
//public class InvoiceDaoTests {
//    @Autowired
//    private InvoiceDao invoiceDao;
//
//
//    @DisplayName("Test case for save method with saving to related tables: 1:N, N:1")
//    @Test
//    void testInvoiceDaoSave() {
//        // Given
//        Product product1 = new Product("Product 1");
//        Product product2 = new Product("Product 2");
//        Product product3 = new Product("Product 3");
//
//        Invoice invoice1 = new Invoice("F/2024/04/28/001");
//        Invoice invoice2 = new Invoice("F/2024/04/28/002");
//
//        Item item1 = new Item(product1, new BigDecimal(10), 11, new BigDecimal(110),invoice1);
//        Item item2 = new Item(product2, new BigDecimal(1), 10, new BigDecimal(10), invoice2);
//        Item item3 = new Item(product3, new BigDecimal(5), 10, new BigDecimal(50), invoice1);
//        Item item4 = new Item(product3, new BigDecimal(5), 1, new BigDecimal(5), invoice2);
//
//
//        invoice1.getItems().add(item1);
//        invoice1.getItems().add(item3);
//        invoice2.getItems().add(item2);
//        invoice2.getItems().add(item4);
//        // When
//        invoiceDao.save(invoice1);
//        int idInvoice1 = invoice1.getId();
//
//        invoiceDao.save(invoice2);
//        int idInvoice2 = invoice2.getId();
//        // Then
//        Assertions.assertNotEquals(0, idInvoice1);
//        Assertions.assertNotEquals(0, idInvoice2);
//        // Cleanup
////        try {
////            invoiceDao.deleteById(idInvoice1);
////            invoiceDao.deleteById(idInvoice2);
////        } catch (Exception e) {
////            // do nothing
////        }
//
//    }
//}
