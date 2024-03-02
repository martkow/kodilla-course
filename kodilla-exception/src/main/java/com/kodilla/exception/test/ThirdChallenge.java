package com.kodilla.exception.test;

public class ThirdChallenge {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        try {
            System.out.println("Your route: " + flightSearch.findFlight(new Flight("A1", "A1")));
        } catch (RouteNotFoundException rnfe) {
            System.out.println("Your route: " + rnfe.getMessage());
        }
    }
}
