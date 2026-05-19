package com.utility.billing.models;

public class Meter {
    private final String meterId;
    private double currentReading;
    private double previousReading;

    public Meter(String meterId) {
        this.meterId = meterId;
        this.currentReading = 0;
        this.previousReading = 0;
    }

    public void setCurrentReading(double reading) { this.currentReading = reading; }
    public double getUnitsConsumed() { return currentReading - previousReading; }
    public String getMeterId() { return meterId; }
}
