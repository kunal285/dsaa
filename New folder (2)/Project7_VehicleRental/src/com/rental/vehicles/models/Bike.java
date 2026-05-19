package com.rental.vehicles.models;

import com.rental.vehicles.exceptions.InvalidRentalException;

public final class Bike extends Vehicle {
    private final int engineCC;
    private final boolean hasHelmet;

    public Bike(String vehicleId, String vehicleName, double dailyRate, int engineCC, boolean hasHelmet) 
            throws InvalidRentalException {
        super(vehicleId, vehicleName, dailyRate);
        this.engineCC = engineCC;
        this.hasHelmet = hasHelmet;
    }

    @Override
    public double calculateRent(int days) throws InvalidRentalException {
        if (days <= 0) {
            throw new InvalidRentalException("Days must be positive");
        }
        double baseRent = dailyRate * days;
        double helmetCharge = hasHelmet ? 100 : 0;
        return baseRent + (helmetCharge * days);
    }

    public int getEngineCC() {
        return engineCC;
    }

    public boolean hasHelmet() {
        return hasHelmet;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", dailyRate=" + dailyRate +
                ", engineCC=" + engineCC +
                ", hasHelmet=" + hasHelmet +
                ", available=" + isAvailable +
                '}';
    }
}
