package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.LongStream;

@DisplayName("Tests for Library class")
public class LibraryTestSuite {
    @DisplayName("Test case for getBooks method")
    @Test
    void testCaseForGetBooksMethod() {
        // Given
        Library library = new Library("Library 1");
        LongStream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(i ->
                        library.getBooks().add(
                                new Book("Book " + i, "Author " + i, LocalDate.now().minusMonths(i))
                        )
                );
        Library libraryShallowCopy = null;
        try {
            libraryShallowCopy = library.shallowCopy();
            libraryShallowCopy.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library libraryDeepCopy = null;
        try {
            libraryDeepCopy = library.deepCopy();
            libraryDeepCopy.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        // When
        library.getBooks().remove(
                new Book("Book " + 1, "Author " + 1, LocalDate.now().minusMonths(1)
                )
        );
        // Then
        library.getBooks().forEach(System.out::println);
        System.out.println(" ");
        libraryShallowCopy.getBooks().forEach(System.out::println);
        System.out.println(" ");
        libraryDeepCopy.getBooks().forEach(System.out::println);
    }
}
