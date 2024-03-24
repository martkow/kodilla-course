package com.kodilla.good.patterns.challenges.clean.code;

import com.kodilla.good.patterns.challenges.clean.code.Main;
import com.kodilla.good.patterns.challenges.clean.code.MovieStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests For Main class")
public class MainTestSuite {
    @DisplayName("Test case for concatMovies method")
    @Test
    void testCaseForConcatMoviesMethod() {
        // Given
        MovieStore movieStore = new MovieStore();
        // When
        String result = Main.concatMovies(movieStore.getMovies());
        // Then
        Assertions.assertEquals("Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash", result);
    }

    @DisplayName("Test case for factorial method for negative numbers")
    @Test
    void testCaseForFactorialMethodForNegativeNumber() {
        // Given
        // When
        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.factorial(-1));
    }

    @DisplayName("Test case for factorial method for non negative number 0")
    @Test
    void testCaseForFactorialMethodForNonNegativeNumberZero() {
        // Given
        // When
        int result = Main.factorial(0);
        // Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("Test case for factorial method for non negative number 1")
    @Test
    void testCaseForFactorialMethodForNonNegativeNumberOne() {
        // Given
        // When
        int result = Main.factorial(1);
        // Then
        Assertions.assertEquals(1, result);
    }

    @DisplayName("Test case for factorial method for non negative number 4")
    @Test
    void testCaseForFactorialMethodForNonNegativeNumberFour() {
        // Given
        // When
        int result = Main.factorial(4);
        // Then
        Assertions.assertEquals(24, result);
    }
}
