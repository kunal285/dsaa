package com.rental.vehicles;

import com.rental.vehicles.exceptions.InvalidRentalException;
import com.rental.vehicles.models.Bike;
import com.rental.vehicles.models.Car;
import com.rental.vehicles.models.Vehicle;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Vehicle Rental System ===\n");

            Car car1 = new Car("V001", "Toyota Camry", 2000.0, 5, true);
            Car car2 = new Car("V002", "Honda City", 1500.0, 5, true);
            Bike bike1 = new Bike("V003", "Hero Honda", 800.0, 150, true);
            Bike bike2 = new Bike("V004", "Royal Enfield", 1200.0, 500, true);

            System.out.println("--- Available Vehicles ---");
            System.out.println(car1);
            System.out.println(car2);
            System.out.println(bike1);
            System.out.println(bike2);

            System.out.println("\n--- Renting Vehicles ---");
            car1.rentVehicle(5);
            System.out.println("✓ Rented " + car1.getVehicleName() + " for 5 days");
            System.out.println("  Rental Cost: Rs. " + car1.calculateRent(5));

            bike1.rentVehicle(3);
            System.out.println("✓ Rented " + bike1.getVehicleName() + " for 3 days");
            System.out.println("  Rental Cost: Rs. " + bike1.calculateRent(3));

            System.out.println("\n--- Vehicle Status ---");
            System.out.println(car1.getVehicleName() + " - Available: " + car1.isAvailable());
            System.out.println(car2.getVehicleName() + " - Available: " + car2.isAvailable());
            System.out.println(bike1.getVehicleName() + " - Available: " + bike1.isAvailable());

            System.out.println("\n--- Returning Vehicles ---");
            car1.returnVehicle();
            System.out.println("✓ Returned " + car1.getVehicleName());

            bike1.returnVehicle();
            System.out.println("✓ Returned " + bike1.getVehicleName());

            System.out.println("\n--- Testing Invalid Operations ---");
            testInvalidRental(car1);
            testNegativeDays(car1);

        } catch (InvalidRentalException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testInvalidRental(Vehicle vehicle) {
        try {
            System.out.println("Attempting to rent unavailable vehicle...");
            vehicle.rentVehicle(5);
            vehicle.rentVehicle(3); // Should fail
        } catch (InvalidRentalException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testNegativeDays(Vehicle vehicle) {
        try {
            System.out.println("Attempting to calculate rent for negative days...");
            vehicle.calculateRent(-5);
        } catch (InvalidRentalException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
