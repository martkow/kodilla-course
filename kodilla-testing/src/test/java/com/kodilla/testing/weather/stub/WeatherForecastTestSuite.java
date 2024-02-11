package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for WeatherForecast class")
public class WeatherForecastTestSuite {
    @DisplayName("Test case for calculateForecast method")
    @Test
    void testCaseCalculateForecastMethod() {
        // Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        // When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        // Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
}
