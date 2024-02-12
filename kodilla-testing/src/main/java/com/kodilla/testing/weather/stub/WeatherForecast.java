package com.kodilla.testing.weather.stub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            resultMap.put(entry.getKey(), entry.getValue() + 1);
        }

        return resultMap;
    }

    public double calculateAverageTemperature() {
        double average = 0;

        if (!temperatures.getTemperatures().isEmpty()) {
            for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
                average += entry.getValue();
            }
            average /= temperatures.getTemperatures().size();
        }
        return average == 0 ? 0 : Math.signum(average) >= 0 ? (int)(average * 100 + 0.5) / 100.0 : (int)(average * 100 - 0.5) / 100.0 ;
    }

    public double calculateMedianOfTemperatures() {
        double median = 0;

        if (!temperatures.getTemperatures().isEmpty()) {
            List<Double> temperaturesList = new ArrayList<>(temperatures.getTemperatures().values());
            temperaturesList.sort(null);
            if (temperaturesList.size() % 2 == 0) {
                median = (temperaturesList.get(temperaturesList.size() / 2) + temperaturesList.get(temperaturesList.size() / 2 - 1)) / 2;
            } else {
                median = temperaturesList.get(temperaturesList.size() / 2);
            }
        }

        return median == 0 ? 0 : Math.signum(median) > 0 ? (int)(median * 100 + 0.5) / 100.0 : (int)(median * 100 - 0.5) / 100.0;
    }
}
