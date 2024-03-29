package com.kodilla.good.patterns.challenges.solid.flights.flight;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;

import java.time.LocalDateTime;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightDurationHours == flight.flightDurationHours && flightDurationMinutes == flight.flightDurationMinutes && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departureDateTime, flight.departureDateTime) && Objects.equals(departure, flight.departure) && Objects.equals(arrival, flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, departureDateTime, flightDurationHours, flightDurationMinutes, departure, arrival);
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
