package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Continent> continentList = new ArrayList<>();

    public World() {
        continentList.add(new Continent("Continent1", new ArrayList<>(List.of(new Country("Country1", new BigDecimal(100)),new Country("Country2", new BigDecimal(200)), new Country("Country3", new BigDecimal(300))))));
        continentList.add(new Continent("Continent2", new ArrayList<>(List.of(new Country("Country4", new BigDecimal(400)),new Country("Country5", new BigDecimal(500))))));
        continentList.add(new Continent("Continent3", new ArrayList<>(List.of(new Country("Country6", new BigDecimal(600)),new Country("Country7", new BigDecimal(700)), new Country("Country8", new BigDecimal(800))))));
    }

    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(c -> c.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
