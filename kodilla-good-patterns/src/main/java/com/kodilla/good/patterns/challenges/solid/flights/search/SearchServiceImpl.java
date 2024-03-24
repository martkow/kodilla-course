package com.kodilla.good.patterns.challenges.solid.flights.search;

import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;
import com.kodilla.good.patterns.challenges.solid.flights.repository.FlightFileRepository;
import com.kodilla.good.patterns.challenges.solid.flights.repository.FlightRepository;
import com.kodilla.good.patterns.challenges.solid.flights.search.request.SearchFlightRequest;

import java.util.List;
import java.util.Objects;

public class SearchServiceImpl implements SearchService {
    private FlightRepository flightRepository = new FlightFileRepository();

    @Override
    public List<Flight> search(SearchFlightRequest searchFlightRequest) {
        List<Flight> flights = flightRepository.retrieve();

        return flights.stream() // how to get rid of toString() method???
                .filter(f -> Objects.requireNonNull(searchFlightRequest.getFrom()).equals(f.getDeparture().toString()))
                .filter(f -> Objects.requireNonNull(searchFlightRequest.getTo()).equals(f.getArrival().toString()))
                .toList();
    }
}
