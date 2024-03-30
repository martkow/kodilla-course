package com.kodilla.good.patterns.challenges.solid.flights.search.seviceV2;

import com.kodilla.good.patterns.challenges.solid.flights.search.requestV2.SearchFlightRequestV2;
import com.kodilla.good.patterns.challenges.solid.flights.search.responseV2.FlightDto;

import java.util.List;

public class SearchProcessorV2 {
    private SearchServiceV2 searchServiceV2;

    public SearchProcessorV2(SearchServiceV2 searchServiceV2) {
        this.searchServiceV2 = searchServiceV2;
    }

    public FlightDto process(SearchFlightRequestV2 searchFlightRequestV2) {
        if (searchFlightRequestV2.getFrom() != null && searchFlightRequestV2.getTo() != null) {
            return new FlightDto(
                    searchFlightRequestV2.isNonStop() ? searchServiceV2.searchDirectFlightsFromTo(searchFlightRequestV2.getFrom(), searchFlightRequestV2.getTo()) : List.of(),
                    searchFlightRequestV2.isOneStop() ? searchServiceV2.searchTransitFlightsFromTo(searchFlightRequestV2.getFrom(), searchFlightRequestV2.getTo()) : List.of());
        } else if (searchFlightRequestV2.getFrom() != null) {
            return new FlightDto(
                    searchServiceV2.searchFlightsFrom(searchFlightRequestV2.getFrom()),
                    List.of());
        } else if (searchFlightRequestV2.getTo() != null) {
            return new FlightDto(
                    searchServiceV2.searchFlightsTo(searchFlightRequestV2.getTo()),
                    List.of());
        }
        return new FlightDto(List.of(), List.of());
    }
}
