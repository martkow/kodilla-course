package com.kodilla.good.patterns.challenges.solid.flights.search;

import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;
import com.kodilla.good.patterns.challenges.solid.flights.search.request.SearchFlightRequest;

import java.util.List;

public interface SearchService {
    List<Flight> search(SearchFlightRequest searchFlightRequest);
}
