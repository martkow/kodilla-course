package com.kodilla.good.patterns.challenges.solid.flights;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;
import com.kodilla.good.patterns.challenges.solid.flights.search.SearchServiceImpl;
import com.kodilla.good.patterns.challenges.solid.flights.search.request.SearchFlightRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@DisplayName("Tests for search method")
public class SearchServiceImplTestSuite {
    @DisplayName("Test case for search method for departure and arrival airports filled in request")
    @Test
    void testCaseForSearchMethodForFromAndToFilled() {
        // Given  LocalDateTime.of(2024, 3, 25, 16, 30, 0)
        List<Flight> flights = List.of(new Flight("BUB 3836", LocalDateTime.parse("2024-03-25 16:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 5, new Airport("WAW"), new Airport("KRK")));
        SearchFlightRequest searchFlightRequest = new SearchFlightRequest("WAW", "KRK");
        SearchServiceImpl searchService = new SearchServiceImpl();
        // When
        List<Flight> result = searchService.search(searchFlightRequest);
        // Then
        Assertions.assertEquals(flights, result);
    }
}
