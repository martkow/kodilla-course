package com.kodilla.good.patterns.challenges.solid.flights.search.responseV2;

import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;

import java.util.List;

public class FlightDto {
    private List<Flight> directFlights;
    private List<Flight[]> transitFlights;

    public FlightDto(List<Flight> directFlights, List<Flight[]> transitFlights) {
        this.directFlights = directFlights;
        this.transitFlights = transitFlights;
    }

    public List<Flight> getDirectFlights() {
        return directFlights;
    }

    public List<Flight[]> getTransitFlights() {
        return transitFlights;
    }
}
