package com.weather.app;


/**
 * Concrete entity that stores the project-specific data.
 */
public class WeatherForecast extends WeatherRecord implements Forecastable {
    private double temperature;
    private double humidity;


    public WeatherForecast(final String name, final double temperature, final double humidity) throws WeatherException {
        super(name);
        if (temperature < -100.0 || temperature > 100.0) {             throw new WeatherException("Temperature looks invalid.");         }         if (humidity < 0.0 || humidity > 100.0) {             throw new WeatherException("Humidity must be between 0 and 100.");         }
        this.temperature = temperature;
        this.humidity = humidity;

    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(final double temperature) throws WeatherException {
        if (temperature < -100.0 || temperature > 100.0) {
            throw new WeatherException("Temperature looks invalid.");
        }
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(final double humidity) throws WeatherException {
        if (humidity < 0.0 || humidity > 100.0) {
            throw new WeatherException("Humidity must be between 0 and 100.");
        }
        this.humidity = humidity;
    }

    @Override
    public String forecast() {
        return "Forecast for " + getName() + ": " + temperature + " C, humidity " + humidity + "%";
    }

    @Override
    public String advice() {
        return humidity > 80.0 ? "Carry an umbrella." : "Weather looks normal.";
    }


    @Override
    public String describe() {
        return getBasicInfo() + ", " + "temperature=" + temperature + ", " + "humidity=" + humidity;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "WeatherForecast";
    }
}