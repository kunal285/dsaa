package com.weather.app.models;

public final class City {
    private final String cityId;
    private final String cityName;
    private final String region;

    public City(String cityId, String cityName, String region) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.region = region;
    }

    public String getCityName() { return cityName; }
    public String getRegion() { return region; }
}

class WeatherData {
    private final double temperature;
    private final double humidity;
    private final String condition;

    public WeatherData(double temperature, double humidity, String condition) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public String getCondition() { return condition; }
}

class Forecast {
    private final String forecastId;
    private final double[] temperatureArray;
    private final double[] humidityArray;
    private static int forecastCounter = 0;

    public Forecast(double[] temperatureArray, double[] humidityArray) {
        this.forecastId = "FC_" + (++forecastCounter);
        this.temperatureArray = temperatureArray;
        this.humidityArray = humidityArray;
    }

    public double getAverageTemperature() {
        double sum = 0;
        for (double temp : temperatureArray) {
            sum += temp;
        }
        return sum / temperatureArray.length;
    }

    public double getAverageHumidity() {
        double sum = 0;
        for (double humidity : humidityArray) {
            sum += humidity;
        }
        return sum / humidityArray.length;
    }

    public String getForecastId() { return forecastId; }
}
