package com.kodilla.good.patterns.challenges.solid.flights.repository;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;
import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightFileRepository implements FlightRepository {
    private static final Path path = Paths.get("src/main/resources/flights.txt");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public List<Flight> retrieve() {
        List<Flight> flights = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(path);

            flights.addAll(lines
                    .stream()
                    .map(l -> { // Any shorter way - one line solution???
                        List<String> flightData = List.of(l.split(","));
                        return new Flight(
                                flightData.get(0),
                                LocalDateTime.parse(flightData.get(1), dateTimeFormatter),
                                Long.parseLong(flightData.get(2)),
                                Long.parseLong(flightData.get(3)),
                                new Airport(flightData.get(4)),
                                new Airport(flightData.get(5))
                        );
                    })
                    .toList());
        } catch (IOException e) {
            System.out.println("Flights not available. Try later. " + e.getMessage());
        }

        return flights;
    }
}
