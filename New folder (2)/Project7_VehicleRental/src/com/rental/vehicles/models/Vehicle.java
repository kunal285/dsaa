package com.rental.vehicles.models;

import com.rental.vehicles.exceptions.InvalidRentalException;
import com.rental.vehicles.interfaces.Rentable;

public abstract class Vehicle implements Rentable {
    protected final String vehicleId;
    protected final String vehicleName;
    protected final double dailyRate;
    protected boolean isAvailable;
    protected int rentalDays;

    public Vehicle(String vehicleId, String vehicleName, double dailyRate) 
            throws InvalidRentalException {
        if (dailyRate < 0) {
            throw new InvalidRentalException("Daily rate cannot be negative");
        }
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
        this.rentalDays = 0;
    }

    @Override
    public abstract double calculateRent(int days) throws InvalidRentalException;

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void rentVehicle(int days) throws InvalidRentalException {
        if (days <= 0) {
            throw new InvalidRentalException("Rental days must be positive");
        }
        if (!isAvailable) {
            throw new InvalidRentalException("Vehicle is not available");
        }
        this.isAvailable = false;
        this.rentalDays = days;
    }

    @Override
    public void returnVehicle() {
        this.isAvailable = true;
        this.rentalDays = 0;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public int getRentalDays() {
        return rentalDays;
    }
}
