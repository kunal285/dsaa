package com.rental.vehicles;


/**
 * Concrete entity that stores the project-specific data.
 */
public class Vehicle extends VehicleRecord implements Rentable {
    private double dailyRate;
    private int rentalDays;
    private boolean rented;


    public Vehicle(final String name, final double dailyRate, final int rentalDays, final boolean rented) throws RentalException {
        super(name);
        if (dailyRate < 0.0) {             throw new RentalException("Daily rate cannot be negative.");         }         if (rentalDays < 1) {             throw new RentalException("Rental days must be at least 1.");         }
        this.dailyRate = dailyRate;
        this.rentalDays = rentalDays;
        this.rented = rented;

    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(final double dailyRate) throws RentalException {
        if (dailyRate < 0.0) {
            throw new RentalException("Daily rate cannot be negative.");
        }
        this.dailyRate = dailyRate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(final int rentalDays) throws RentalException {
        if (rentalDays < 1) {
            throw new RentalException("Rental days must be at least 1.");
        }
        this.rentalDays = rentalDays;
    }

    public boolean getRented() {
        return rented;
    }

    public void setRented(final boolean rented) throws RentalException {
        this.rented = rented;
    }

    @Override
    public double calculateRentalCost() {
        return dailyRate * rentalDays;
    }

    @Override
    public String rentVehicle() {
        return rented ? "Vehicle is already rented." : "Vehicle rented successfully.";
    }


    public String describe() {
        return getBasicInfo() + ", " + "dailyRate=" + dailyRate + ", " + "rentalDays=" + rentalDays + ", " + "rented=" + rented;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "Vehicle";
    }
}