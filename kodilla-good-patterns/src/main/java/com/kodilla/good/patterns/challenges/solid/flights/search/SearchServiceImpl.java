package com.kodilla.good.patterns.challenges.solid.flights.search;

import com.kodilla.good.patterns.challenges.solid.flights.flight.Flight;
import com.kodilla.good.patterns.challenges.solid.flights.repository.FlightFileRepository;
import com.kodilla.good.patterns.challenges.solid.flights.repository.FlightRepository;
import com.kodilla.good.patterns.challenges.solid.flights.search.request.SearchFlightRequest;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {
    private FlightRepository flightRepository = new FlightFileRepository();

    @Override
    public List<Flight> search(SearchFlightRequest searchFlightRequest) {
        List<Flight> flights = flightRepository.retrieve();

        if (searchFlightRequest.getFrom() != null && searchFlightRequest.getTo() != null) {
            List<Flight> withLayover = new ArrayList<>();
            for (Flight fromFlight : flights) {
                if (searchFlightRequest.getFrom().equals(fromFlight.getDeparture().toString())) {
                    for (Flight toFlight : flights) {
                        if (searchFlightRequest.getTo().equals(toFlight.getArrival().toString()) && fromFlight.getArrival().equals(toFlight.getDeparture())) {
                            withLayover.add(fromFlight);
                            withLayover.add(toFlight);
                        }
                    }
                }
            }
            return withLayover.stream()
                    .distinct()
                    .toList();
        }

        return flights.stream() // how to get rid of toString() method???
                .filter(f -> searchFlightRequest.getFrom() == null || searchFlightRequest.getFrom().equals(f.getDeparture().toString()))
                .filter(f -> searchFlightRequest.getTo() == null || searchFlightRequest.getTo().equals(f.getArrival().toString()))
                .toList();
    }
}
