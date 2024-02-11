package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures {
    @Override
    public Map<String, Double> getTemperatures() {
        Map<String, Double> stubResult = new HashMap<>();

        stubResult.put("Toruń", -10.00);
        stubResult.put("Gdańsk", -5.60);
        stubResult.put("Gdynia", -3.00);
        stubResult.put("Kraków", -9.30);
        stubResult.put("Zakopane", -22.00);

        return stubResult;
    }
}
