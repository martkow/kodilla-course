package com.kodilla.exception.test;

import java.util.*;
import java.util.stream.Collectors;

public class FlightSearch {

    private static final Set<String> airportsSet = new HashSet<>(Set.of("A1", "A2", "A3"));
    private Map<Set<String>, Boolean> airportsConnectionMap = new HashMap<>();

    public FlightSearch() {
        airportsConnectionMap.put(new HashSet<>(Set.of("A1", "A2")), true);
        airportsConnectionMap.put(new HashSet<>(Set.of("A1", "A3")), false);
        airportsConnectionMap.put(new HashSet<>(Set.of("A2", "A3")), true);
    }

    public String  findFlight(Flight flight) throws RouteNotFoundException {
        if (flight.getArrivalAirport().equals(flight.getDepartureAirport())) {
            throw new RouteNotFoundException("Wrong data");
        }
         Set<Set<String>> route = airportsConnectionMap.entrySet().stream()
                .filter(e -> e.getKey().containsAll(Set.of(flight.getArrivalAirport(), flight.getDepartureAirport())) && e.getValue())
                .map(e -> e.getKey())
                .collect(Collectors.toSet());
        if (route.isEmpty()) {
            throw new RouteNotFoundException("Route not found");
        }
        return route.toString();
    }
}
