package com.kodilla.good.patterns.challenges.solid.flights.search.requestV2;

import com.kodilla.good.patterns.challenges.solid.flights.airport.Airport;

public class SearchFlightRequestV2 {
    private Airport from;
    private Airport to;
    private boolean nonStop;
    private boolean oneStop;

    public SearchFlightRequestV2(String from, String to) {
        if (from != null) {
            this.from = new Airport(from);
        }
        if (to != null) {
            this.to = new Airport(to);
        }
    }

    public SearchFlightRequestV2(String from, String to, boolean nonStop, boolean oneStop) {
        this(from, to);
        this.nonStop = nonStop;
        this.oneStop = oneStop;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public boolean isNonStop() {
        return nonStop;
    }

    public boolean isOneStop() {
        return oneStop;
    }
}
