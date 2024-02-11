package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@DisplayName("Tests for WeatherForecast class")
@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;

    @DisplayName("Tests for nonempty map given to WeatherForecast class")
    @Nested
    class TestsForNonemptyMap {
        @BeforeEach
        void testCaseStartPreparation() {
            Mockito.when(temperaturesMock.getTemperatures()).thenReturn(
                    new HashMap<>(Map.ofEntries(
                            Map.entry("Toruń", -10.00),
                            Map.entry("Kraków", -13.50),
                            Map.entry("Gdańsk", 3.33),
                            Map.entry("Gdynia", -0.50),
                            Map.entry("Warszawa", -1.50)
                    )));
        }

        @DisplayName("Test case for calculateForecast method")
        @Test
        void testCaseCalculateForecastMethod() {
            // Given
            //Temperatures temperaturesMock = Mockito.mock(Temperatures.class);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            // When
            int quantifyOfSensors = weatherForecast.calculateForecast().size();
            // Then
            Assertions.assertEquals(5, quantifyOfSensors);
        }

        @DisplayName("Test case for calculateAverageTemperature method for nonempty map")
        @Test
        void testCaseCalculateAverageTemperatureMethodForNonemptyMap() {
            // Given
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            // When
            double result = weatherForecast.calculateAverageTemperature();
            // Then
            Assertions.assertEquals(-4.43, result);
        }

        @DisplayName("Test case for calculateMedianOfTemperatures method for odd numbers of elements in map")
        @Test
        void testCaseCalculateMedianOfTemperaturesMethodForOddNumbersOfElementsInMap() {
            // Given
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            // When
            double result = weatherForecast.calculateMedianOfTemperatures();
            // Then
            Assertions.assertEquals(-1.50, result);
        }

        @DisplayName("Test case for calculateMedianOfTemperaturesMethodForEvenNumberOfElementsInMap")
        @Test
        void calculateMedianOfTemperaturesMethodForEvenNumberOfElementsInMap() {
            // Given
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            Mockito.when(temperaturesMock.getTemperatures()).thenReturn(
                    new HashMap<>(Map.ofEntries(
                            Map.entry("Toruń", -10.00),
                            Map.entry("Kraków", -13.50),
                            Map.entry("Gdynia", -1.50),
                            Map.entry("Warszawa", -5.33)
                    )));
            // When
            double result = weatherForecast.calculateMedianOfTemperatures();
            // Then
            Assertions.assertEquals(-7.67, result);
        }
    }

    @DisplayName("Tests for empty map given to WeatherForecast class")
    @Nested
    class TestsForEmptyMap {
        @DisplayName("Test case for calculateAverageTemperature method for empty map")
        @Test
        void testCaseCalculateAverageTemperatureMethodForEmptyMap() {
            // Given
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            // When
            double result = weatherForecast.calculateAverageTemperature();
            // Then
            Assertions.assertEquals(0, result);
        }

        @DisplayName("Test case for calculateMedianOfTemperatures method for empty map")
        @Test
        void testCaseCalculateMedianOfTemperaturesForEmptyMap() {
            // Given
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
            // When
            double result = weatherForecast.calculateMedianOfTemperatures();
            // Then
            Assertions.assertEquals(0, result);
        }
    }
}
