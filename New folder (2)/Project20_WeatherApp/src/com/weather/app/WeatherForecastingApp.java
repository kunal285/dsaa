package com.weather.app;

import com.weather.app.models.City;
import com.weather.app.models.Forecast;

public class WeatherForecastingApp {
    public static void main(String[] args) {
        System.out.println("=== Weather Forecasting Application ===\n");
        
        City city = new City("C001", "Mumbai", "Maharashtra");
        double[] temperatures = {28.5, 29.0, 27.8, 29.5, 28.2};
        double[] humidity = {75.0, 78.0, 72.0, 76.0, 74.0};
        
        Forecast forecast = new Forecast(temperatures, humidity);
        
        System.out.println("✓ City: " + city.getCityName() + ", " + city.getRegion());
        System.out.println("\n--- 5-Day Forecast ---");
        System.out.println("Average Temperature: " + String.format("%.2f", forecast.getAverageTemperature()) + "°C");
        System.out.println("Average Humidity: " + String.format("%.2f", forecast.getAverageHumidity()) + "%");
        System.out.println("Forecast ID: " + forecast.getForecastId());
    }
}
