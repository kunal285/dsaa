package com.weather.app;

/**
 * Computes a forecast from city metadata and weather history.
 */
public class Forecast extends WeatherRecord implements Forecastable {
    private final City city;
    private final WeatherData weatherData;

    public Forecast(final String name, final City city, final WeatherData weatherData) throws WeatherException {
        super(name);
        if (city == null) {
            throw new WeatherException("City cannot be null.");
        }
        if (weatherData == null) {
            throw new WeatherException("Weather data cannot be null.");
        }

        this.city = city;
        this.weatherData = weatherData;
    }

    public City getCity() {
        return city;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    @Override
    public String forecast() {
        return "Forecast for " + city.getName() + ": average temperature " + weatherData.averageTemperature() + " C, average humidity " + weatherData.averageHumidity() + "%";
    }

    @Override
    public String advice() {
        return weatherData.averageHumidity() > 80.0 ? "Carry an umbrella." : "Weather looks normal.";
    }

    @Override
    public String getCategory() {
        return "Forecast";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", city=" + city.getName() + ", temperatureTrend=" + (weatherData.averageTemperature() >= 25.0 ? "Warm" : "Cool") + ", humidityTrend=" + weatherData.humidityTrend();
    }

    @Override
    public String toString() {
        return describe();
    }
}