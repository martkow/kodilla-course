package com.kodilla.stream.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Tests for BookDirectory class")
public class BookDirectoryTestSuite {
    @DisplayName("Test case for getList method using 'for loop'")
    @Test
    void testCaseForGetListMethodUsingFor() {
        // Given
        BookDirectory bookDirectory = new BookDirectory();
        // When
        List<Book> bookList = bookDirectory.getList();
        // Then
        int numberOfBooksPublishedAfter2007 = 0;
        for (Book book : bookList) {
            if (book.getPublicationYear() > 2007) {
                numberOfBooksPublishedAfter2007++;
            }
        }
        Assertions.assertEquals(3, numberOfBooksPublishedAfter2007);
    }

    @DisplayName("Test case for getList method using 'IntStream'")
    @Test
    void testCaseForGetListMethodUsingIntStream() {
        // Given
        BookDirectory bookDirectory = new BookDirectory();
        // When
        List<Book> bookList = bookDirectory.getList();
        // Then
        long numberOfBooksPublishedAfter2007 = bookList.stream()
                .filter(b -> b.getPublicationYear() > 2007)
                .count();
        Assertions.assertEquals(3, numberOfBooksPublishedAfter2007);
    }
}
