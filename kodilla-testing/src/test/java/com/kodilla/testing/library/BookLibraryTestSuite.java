package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests for BookLibrary class")
public class BookLibraryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @DisplayName("Tests for listBooksWithCondition method")
    @Nested
    class TestsForListBooksWithConditionMethod {
        @DisplayName("Test case for listBooksWithCondition method where result list has greater than 20 books - should return empty list")
        @Test
        void testCaseListBooksWithConditionMethodForResultListHavingMoreThan20Books() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            Mockito.when(libraryDatabaseMock.listBooksWithCondition("Jav")).thenReturn(generateListOfBooks(21));
            // When
            List<Book> result = bookLibrary.listBooksWithCondition("Jav");
            // Then
            Assertions.assertEquals(new ArrayList<>(), result);
        }

        @DisplayName("Test case for listBooksWithCondition method where method's parameter titleFragment has less than 3 characters - should return empty list")
        @Test
        void testCaseListBooksWithConditionMethodForConditionHavingLessThan3Characters() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            // When
            List<Book> result = bookLibrary.listBooksWithCondition("Ja");
            // Then
            Assertions.assertEquals(new ArrayList<>(), result);
            Mockito.verify(libraryDatabaseMock, Mockito.times(0)).listBooksWithCondition(Mockito.anyString());
        }

        @DisplayName("Test case for listBooksWithCondition method where method's parameter titleFragment has at least 3 characters and result list has less or equal than 20 books")
        @Test
        void testCaseListBooksWithConditionMethodForConditionHavingAtLeast3CharactersAndListHavingLessOrEqualThan20Books() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            Mockito.when(libraryDatabaseMock.listBooksWithCondition("Jav")).thenReturn(generateListOfBooks(20));
            // When
            List<Book> result = bookLibrary.listBooksWithCondition("Jav");
            // Then
            Assertions.assertEquals(generateListOfBooks(20), result);
        }

        @DisplayName("Test case for listBooksWithCondition method where method's parameter titleFragment has at least 3 characters and result list has 0 books - should return result list")
        @Test
        void testCaseListBooksWithConditionMethodForConditionHavingAtLeast3CharactersAndListHaving0Books() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            // When
            List<Book> result = bookLibrary.listBooksWithCondition("Ja");
            // Then
            Assertions.assertEquals(new ArrayList<>(), result);
        }
    }

    @DisplayName("Tests listBooksInHandsOf method")
    @Nested
    class TestsForListBooksInHandsOf {
        @DisplayName("Test case for listBooksInHandsOf for libraryUser with no books")
        @Test
        void testCaseForListBooksInHandsOfMethodForLibraryUserWithNoBooks(){
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            // When
            List<Book> result = bookLibrary.listBooksInHandsOf(new LibraryUser("Bubu", "Bubuslawski", "00"));
            // Then
            Assertions.assertEquals(new ArrayList<>(), result);
        }

        @DisplayName("Test case for listBooksInHandsOf for libraryUser with one book")
        @Test
        void testCaseForListBooksInHandsOfMethodForLibraryUserWithOneBook(){
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            Mockito.when(libraryDatabaseMock.listBooksInHandsOf(new LibraryUser("Bubu", "Bubuslawski", "00")))
                    .thenReturn(generateListOfBooks(1));
            // When
            List<Book> result = bookLibrary.listBooksInHandsOf(new LibraryUser("Bubu", "Bubuslawski", "00"));
            // Then
            Assertions.assertEquals(generateListOfBooks(1), result);
        }

        @DisplayName("Test case for listBooksInHandsOf for libraryUser with five books")
        @Test
        void testCaseForListBooksInHandsOfMethodForLibraryUserWithFiveBooks(){
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            Mockito.when(libraryDatabaseMock.listBooksInHandsOf(new LibraryUser("Bubu", "Bubuslawski", "00")))
                    .thenReturn(generateListOfBooks(5));
            // When
            List<Book> result = bookLibrary.listBooksInHandsOf(new LibraryUser("Bubu", "Bubuslawski", "00"));
            // Then
            Assertions.assertEquals(generateListOfBooks(5), result);
        }
    }

    public List<Book> generateListOfBooks(int booksQuantity) {
        List<Book> bookList = new ArrayList<>();

        for (int i = 0; i < booksQuantity; i++) {
            bookList.add(new Book("Java" + i, "J. Javax" + i, 1999 + i));
        }

        return bookList;
    }
}
