package com.weather.app;

/**
 * Represents a city used in the forecast.
 */
public class City extends WeatherRecord {
    private final String country;
    private final String timezone;

    public City(final String name, final String country, final String timezone) throws WeatherException {
        super(name);
        if (country == null || country.trim().isEmpty()) {
            throw new WeatherException("Country cannot be blank.");
        }
        if (timezone == null || timezone.trim().isEmpty()) {
            throw new WeatherException("Timezone cannot be blank.");
        }

        this.country = country.trim();
        this.timezone = timezone.trim();
    }

    public String getCountry() {
        return country;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public String getCategory() {
        return "City";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", country=" + country + ", timezone=" + timezone;
    }

    @Override
    public String toString() {
        return describe();
    }
}