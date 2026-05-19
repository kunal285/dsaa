package com.rental.vehicles.models;

import com.rental.vehicles.exceptions.InvalidRentalException;

public final class Car extends Vehicle {
    private final int seats;
    private final boolean hasAC;

    public Car(String vehicleId, String vehicleName, double dailyRate, int seats, boolean hasAC) 
            throws InvalidRentalException {
        super(vehicleId, vehicleName, dailyRate);
        this.seats = seats;
        this.hasAC = hasAC;
    }

    @Override
    public double calculateRent(int days) throws InvalidRentalException {
        if (days <= 0) {
            throw new InvalidRentalException("Days must be positive");
        }
        double baseRent = dailyRate * days;
        double acCharges = hasAC ? (baseRent * 0.1) : 0;
        return baseRent + acCharges;
    }

    public int getSeats() {
        return seats;
    }

    public boolean hasAC() {
        return hasAC;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vehicleId='" + vehicleId + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", dailyRate=" + dailyRate +
                ", seats=" + seats +
                ", hasAC=" + hasAC +
                ", available=" + isAvailable +
                '}';
    }
}
