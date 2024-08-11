package com.kodilla.kodilla.good.patterns2.adapter.bookclassifier;

import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.libraya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

@DisplayName("Tests for MedianAdapter class")
public class MedianAdapterTests {
    @Test
    void shouldReturnPublicationYearMedian() {
        // Given
        Book b1 = new Book("B. Bubuslawski", "Bubus's life", 2020, "BB/1");
        Book b2 = new Book("B. Bubuslawski", "Bubus's life 2", 2021, "BB/2");
        Book b3 = new Book("B. Bubuslawski", "Bubus's life 3", 2022, "BB/3");
        Book b4 = new Book("B. Bubuslawski", "Bubus's life 4", 2024, "BB/4");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(b1);
        bookSet.add(b2);
        bookSet.add(b3);
        bookSet.add(b4);

        MedianAdapter medianAdapter = new MedianAdapter();
        // When
        int result = medianAdapter.publicationYearMedian(bookSet);
        // Then
        Assertions.assertEquals(2022, result);
    }
}
