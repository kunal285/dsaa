package com.rental.vehicles.interfaces;

import com.rental.vehicles.exceptions.InvalidRentalException;

public interface Rentable {
    double calculateRent(int days) throws InvalidRentalException;
    boolean isAvailable();
    void rentVehicle(int days) throws InvalidRentalException;
    void returnVehicle();
}
