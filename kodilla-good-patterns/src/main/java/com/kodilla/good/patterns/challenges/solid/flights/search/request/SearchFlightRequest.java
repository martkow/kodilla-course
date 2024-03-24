package com.kodilla.good.patterns.challenges.solid.flights.search.request;

public class SearchFlightRequest {
    private String from;
    private String to;

    public SearchFlightRequest(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
