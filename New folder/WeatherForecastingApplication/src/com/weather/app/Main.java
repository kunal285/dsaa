package com.weather.app;

import java.util.Scanner;

/**
 * Main driver used to test the Weather Forecasting Application project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.println("=== Weather Forecasting Application ===");
                final String cityName = readString(scanner, "Enter city name [Bengaluru]: ", "Bengaluru");
                final String country = readString(scanner, "Enter country [India]: ", "India");
                final String timezone = readString(scanner, "Enter timezone [IST]: ", "IST");

                final double[] temperatures = new double[] {
                    readDouble(scanner, "Temperature day 1 [28.5]: ", "28.5"),
                    readDouble(scanner, "Temperature day 2 [29.0]: ", "29.0"),
                    readDouble(scanner, "Temperature day 3 [30.1]: ", "30.1")
                };

                final double[] humidities = new double[] {
                    readDouble(scanner, "Humidity day 1 [60]: ", "60"),
                    readDouble(scanner, "Humidity day 2 [68]: ", "68"),
                    readDouble(scanner, "Humidity day 3 [72]: ", "72")
                };

                final City city = new City(cityName, country, timezone);
                final WeatherData weatherData = new WeatherData(cityName, temperatures, humidities);
                final Forecast forecast = new Forecast("Forecast-1", city, weatherData);

                final ForecastManager manager = new ForecastManager();
                manager.add(new WeatherForecast(cityName, weatherData.averageTemperature(), weatherData.averageHumidity()));

                System.out.println("Stored forecast:");
                manager.printAll();
                System.out.println(city);
                System.out.println(weatherData);
                System.out.println(forecast.forecast());
                System.out.println(forecast.advice());
            } catch (final WeatherException ex) {
                System.out.println("Validation error: " + ex.getMessage());
            }
        }
    }

    private static String readString(final Scanner scanner, final String prompt, final String defaultValue) {
        System.out.print(prompt);
        final String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }

    private static double readDouble(final Scanner scanner, final String prompt, final String defaultValue) {
        while (true) {
            System.out.print(prompt);
            final String input = scanner.nextLine().trim();
            final String effectiveValue = input.isEmpty() ? defaultValue : input;
            try {
                return Double.parseDouble(effectiveValue);
            } catch (final NumberFormatException ex) {
                System.out.println("Please enter a valid decimal number.");
            }
        }
    }

}