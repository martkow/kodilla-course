package com.kodilla.good.patterns.challenges.solid.flights.search.seviceV2;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;

import java.util.List;

public interface SearchServiceV2 {
    List<Flight> searchFlightsFrom(Airport from);
    List<Flight> searchFlightsTo(Airport to);
    List<Flight> searchDirectFlightsFromTo(Airport from, Airport to);
    List<Flight[]> searchTransitFlightsFromTo(Airport from, Airport to);
}
