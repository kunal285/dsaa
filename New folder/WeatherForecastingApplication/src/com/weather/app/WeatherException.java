package com.weather.app;

/**
 * Custom checked exception for validation errors.
 */
public class WeatherException extends Exception {
    public WeatherException(final String message) {
        super(message);
    }
}