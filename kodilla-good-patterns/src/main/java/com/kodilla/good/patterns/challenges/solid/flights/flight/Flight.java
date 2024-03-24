package com.kodilla.good.patterns.challenges.solid.flights.flight;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;

import java.time.LocalDateTime;

public class Flight {
    private String flightNumber;
    private LocalDateTime departureDateTime;
// Any better way to save flight duration???
    private long flightDurationHours;
    private long flightDurationMinutes;
    private Airport departure;
    private Airport arrival;

    public Flight(String flightNumber, LocalDateTime departureDateTime, long flightDurationHours, long flightDurationMinutes, Airport departure, Airport arrival) {
        this.flightNumber = flightNumber;
        this.departureDateTime = departureDateTime;
        this.flightDurationHours = flightDurationHours;
        this.flightDurationMinutes = flightDurationMinutes;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureDateTime=" + departureDateTime +
                ", flightDurationHours=" + flightDurationHours +
                ", flightDurationMinutes=" + flightDurationMinutes +
                ", departure=" + departure +
                ", arrival=" + arrival +
                '}';
    }
}
