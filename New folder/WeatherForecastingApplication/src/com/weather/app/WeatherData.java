package com.weather.app;

import java.util.Arrays;

/**
 * Holds temperature and humidity history using arrays.
 */
public class WeatherData extends WeatherRecord {
    private final double[] temperatures;
    private final double[] humidities;

    public WeatherData(final String name, final double[] temperatures, final double[] humidities) throws WeatherException {
        super(name);
        if (temperatures == null || humidities == null) {
            throw new WeatherException("Weather arrays cannot be null.");
        }
        if (temperatures.length == 0 || humidities.length == 0) {
            throw new WeatherException("Weather arrays cannot be empty.");
        }

        this.temperatures = Arrays.copyOf(temperatures, temperatures.length);
        this.humidities = Arrays.copyOf(humidities, humidities.length);
        validateRanges();
    }

    private void validateRanges() throws WeatherException {
        for (double temperature : temperatures) {
            if (temperature < -100.0 || temperature > 100.0 || Double.isNaN(temperature)) {
                throw new WeatherException("Invalid temperature format.");
            }
        }
        for (double humidity : humidities) {
            if (humidity < 0.0 || humidity > 100.0 || Double.isNaN(humidity)) {
                throw new WeatherException("Humidity must be between 0 and 100.");
            }
        }
    }

    public double[] getTemperatures() {
        return Arrays.copyOf(temperatures, temperatures.length);
    }

    public double[] getHumidities() {
        return Arrays.copyOf(humidities, humidities.length);
    }

    public double averageTemperature() {
        double total = 0.0;
        for (double temperature : temperatures) {
            total += temperature;
        }
        return total / temperatures.length;
    }

    public double averageHumidity() {
        double total = 0.0;
        for (double humidity : humidities) {
            total += humidity;
        }
        return total / humidities.length;
    }

    public String humidityTrend() {
        return humidities[humidities.length - 1] >= humidities[0] ? "Rising" : "Falling";
    }

    @Override
    public String getCategory() {
        return "WeatherData";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", avgTemp=" + averageTemperature() + ", avgHumidity=" + averageHumidity();
    }

    @Override
    public String toString() {
        return describe();
    }
}