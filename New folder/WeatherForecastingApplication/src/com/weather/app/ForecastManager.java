package com.weather.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection-backed manager for WeatherForecast objects.
 */
public class ForecastManager {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<WeatherForecast> items = new ArrayList<>();

    public void add(final WeatherForecast item) throws WeatherException {
        if (item == null) {
            throw new WeatherException("Record cannot be null.");
        }

        if (items.size() >= MAX_ITEMS) {
            throw new WeatherException("Maximum capacity reached.");
        }

        items.add(item);
    }

    public List<WeatherForecast> getAll() {
        return Collections.unmodifiableList(items);
    }

    public WeatherForecast findByName(final String name) {
        for (WeatherForecast item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public void printAll() {
        if (items.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        for (WeatherForecast item : items) {
            System.out.println(item);
        }
    }
}