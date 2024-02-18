package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private String name;
    private List<Country> countryList = new ArrayList<>();

    public Continent(String name, List<Country> countryList) {
        this.name = name;
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
