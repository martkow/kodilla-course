package com.kodilla.good.patterns.challenges.solid.flights;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;
import com.kodilla.good.patterns.challenges.solid.flights.repository.FlightFileRepository;
import com.kodilla.good.patterns.challenges.solid.flights.search.requestV2.SearchFlightRequestV2;
import com.kodilla.good.patterns.challenges.solid.flights.search.responseV2.FlightDto;
import com.kodilla.good.patterns.challenges.solid.flights.search.seviceV2.SearchProcessorV2;
import com.kodilla.good.patterns.challenges.solid.flights.search.seviceV2.SearchServiceV2Impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@DisplayName("Tests for process method")
public class SearchProcessorV2TestSuite {
    @DisplayName("Test case for process method for departure and arrival airports filled in request with non-stop=1, one-stop=1")
    @Test
    void testCaseForProcessMethodForFromAndToFilled() {
        // Given
        FlightDto flightDto = new FlightDto(
                List.of(),
                List.of(
                        new Flight[]{
                                new Flight("BUB 3837", LocalDateTime.parse("2024-03-24 22:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 0, 55, new Airport("WAW"), new Airport("GDN")),
                                new Flight("BUB 3833", LocalDateTime.parse("2024-03-25 18:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 5, new Airport("GDN"), new Airport("WRO"))
                        },
                        new Flight[]{
                                new Flight("BUB 1137", LocalDateTime.parse("2024-03-24 23:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 0, new Airport("WAW"), new Airport("GDN")),
                                new Flight("BUB 3833", LocalDateTime.parse("2024-03-25 18:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 5, new Airport("GDN"), new Airport("WRO"))
                        }
                )
        );

        SearchFlightRequestV2 searchFlightRequestV2 = new SearchFlightRequestV2("WAW", "WRO", true, true);
        SearchProcessorV2 searchProcessorV2 = new SearchProcessorV2(new SearchServiceV2Impl(new FlightFileRepository()));
        // When
        FlightDto result = searchProcessorV2.process(searchFlightRequestV2);
        // Then
        Assertions.assertTrue(flightDto.getDirectFlights().size() == result.getDirectFlights().size() && flightDto.getDirectFlights().containsAll(result.getDirectFlights()) && result.getDirectFlights().containsAll(flightDto.getDirectFlights()));
        Assertions.assertTrue(flightDto.getTransitFlights().size() == result.getTransitFlights().size());
    }

    @DisplayName("Test case for process method for arrival airport filled in request")
    @Test
    void testCaseForProcessMethodForToFilled() {
        // Given
        FlightDto flightDto = new FlightDto(
                List.of(
                        new Flight("BUB 3833", LocalDateTime.parse("2024-03-25 18:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), 1, 5, new Airport("GDN"), new Airport("WRO"))
                ),
                List.of()
        );

        SearchFlightRequestV2 searchFlightRequestV2 = new SearchFlightRequestV2(null, "WRO");
        SearchProcessorV2 searchProcessorV2 = new SearchProcessorV2(new SearchServiceV2Impl(new FlightFileRepository()));
        // When
        FlightDto result = searchProcessorV2.process(searchFlightRequestV2);
        // Then
        System.out.println(result.getDirectFlights());
        Assertions.assertTrue(flightDto.getDirectFlights().size() == result.getDirectFlights().size() && flightDto.getDirectFlights().containsAll(result.getDirectFlights()) && result.getDirectFlights().containsAll(flightDto.getDirectFlights()));
        Assertions.assertTrue(flightDto.getTransitFlights().size() == result.getTransitFlights().size());
    }
}
