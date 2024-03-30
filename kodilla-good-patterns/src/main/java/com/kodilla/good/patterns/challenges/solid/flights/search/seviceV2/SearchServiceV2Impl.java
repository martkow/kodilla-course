package com.kodilla.good.patterns.challenges.solid.flights.search.seviceV2;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;
import com.kodilla.good.patterns.challenges.solid.flights.repository.FlightRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchServiceV2Impl implements SearchServiceV2 {
    private FlightRepository flightRepository;

    public SearchServiceV2Impl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> searchFlightsFrom(Airport from) {
        return flightRepository.retrieve().stream()
                .filter(f -> f.getDeparture().equals(from))
                .collect(Collectors.toList());
    }

    public List<Flight> searchFlightsTo(Airport to) {
        return flightRepository.retrieve().stream()
                .filter(f -> f.getArrival().equals(to))
                .collect(Collectors.toList());
    }

    public List<Flight> searchDirectFlightsFromTo(Airport from, Airport to) {
        return flightRepository.retrieve().stream()
                        .filter(f -> f.getDeparture().equals(from) && f.getArrival().equals(to))
                        .collect(Collectors.toList());
    }

    public List<Flight[]> searchTransitFlightsFromTo(Airport from, Airport to) {
        List<Flight> flightsFrom = searchFlightsFrom(from);
        List<Flight> flightsTo = searchFlightsTo(to);

        List<Flight[]> transitFlights = new ArrayList<>();
        for (Flight flightFrom: flightsFrom) {
            flightsTo.stream()
                    .filter(f -> f.getDeparture().equals(flightFrom.getArrival()))
                    .map(f -> new Flight[]{flightFrom, f})
                    .forEach(transitFlights::add);
        }
        return transitFlights;
    }
}