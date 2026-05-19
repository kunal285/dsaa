package com.weather.app;

/**
 * Contract for Forecastable behavior.
 */
public interface Forecastable {
    String forecast();
    String advice();
}