package com.kodilla.good.patterns.challenges.solid.flights.repository;

import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> retrieve();
}
