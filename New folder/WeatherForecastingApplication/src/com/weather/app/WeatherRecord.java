package com.weather.app;

/**
 * Base class that provides id generation and common name handling.
 */
public abstract class WeatherRecord {
    private static int nextId = 1;

    private final int id;
    private String name;

    protected WeatherRecord(final String name) throws WeatherException {
        validateName(name);
        this.id = nextId++;
        this.name = name.trim();
    }

    private void validateName(final String value) throws WeatherException {
        if (value == null || value.trim().isEmpty()) {
            throw new WeatherException("Name cannot be blank.");
        }
    }

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) throws WeatherException {
        validateName(name);
        this.name = name.trim();
    }

    public abstract String getCategory();

    public String describe() {
        return getBasicInfo();
    }

    public String getBasicInfo() {
        return getCategory() + " [ID=" + id + ", Name=" + name + "]";
    }
}