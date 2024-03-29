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
        // Given
        List<Flight> flights = List.of(
                new Flight("BUB 3837", LocalDateTime.parse("2024-03-24 22:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 0, 55, new Airport("WAW"), new Airport("GDN")),
                new Flight("BUB 1137", LocalDateTime.parse("2024-03-24 23:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 0, new Airport("WAW"), new Airport("GDN")),
                new Flight("BUB 3833", LocalDateTime.parse("2024-03-25 18:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 5, new Airport("GDN"), new Airport("WRO")));
        SearchFlightRequest searchFlightRequest = new SearchFlightRequest("WAW", "WRO");
        SearchServiceImpl searchService = new SearchServiceImpl();
        // When
        List<Flight> result = searchService.search(searchFlightRequest);
        // Then
        System.out.println(flights);
        System.out.println(result);
        Assertions.assertTrue(flights.size() == result.size() && flights.containsAll(result) && result.containsAll(flights));
    }

    @DisplayName("Test case for search method for departure airport filled in request")
    @Test
    void testCaseForSearchMethodForFromFilled() {
        // Given
        List<Flight> flights = List.of(
                new Flight("BUB 0037", LocalDateTime.parse("2024-03-25 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 0, 55, new Airport("GDN"), new Airport("WAW")),
                new Flight("BUB 3833", LocalDateTime.parse("2024-03-25 18:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 5, new Airport("GDN"), new Airport("WRO")));
        SearchFlightRequest searchFlightRequest = new SearchFlightRequest("GDN", null);
        SearchServiceImpl searchService = new SearchServiceImpl();
        // When
        List<Flight> result = searchService.search(searchFlightRequest);
        // Then
        Assertions.assertTrue(flights.size() == result.size() && flights.containsAll(result) && result.containsAll(flights));
    }

    @DisplayName("Test case for search method for arrival airport filled in request")
    @Test
    void testCaseForSearchMethodForToFilled() {
        // Given
        List<Flight> flights = List.of(
                new Flight("BUB 3837", LocalDateTime.parse("2024-03-24 22:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 0, 55, new Airport("WAW"), new Airport("GDN")),
                new Flight("BUB 1137", LocalDateTime.parse("2024-03-24 23:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 0, new Airport("WAW"), new Airport("GDN")));
        SearchFlightRequest searchFlightRequest = new SearchFlightRequest(null, "GDN");
        SearchServiceImpl searchService = new SearchServiceImpl();
        // When
        List<Flight> result = searchService.search(searchFlightRequest);
        // Then
        Assertions.assertTrue(flights.size() == result.size() && flights.containsAll(result) && result.containsAll(flights));
    }
}
