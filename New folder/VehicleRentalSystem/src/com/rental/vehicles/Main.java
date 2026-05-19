package com.rental.vehicles;

import java.util.Scanner;

/**
 * Main driver used to test the Vehicle Rental System project.
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final RentalManager manager = new RentalManager();

        try {
            System.out.println("=== Vehicle Rental System ===");
            final String name = readString(scanner, "Enter name [Demo]: ", "Demo");
            final double dailyRate = readDouble(scanner, "Enter daily rate [1200]: ", "1200");             final int rentalDays = readInt(scanner, "Enter rental days [3]: ", "3");             final boolean rented = readBoolean(scanner, "Is vehicle rented? [false]: ", "false");
            final Vehicle sample = new Vehicle(name, dailyRate, rentalDays, rented);

            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Rental cost: " + sample.calculateRentalCost());
            System.out.println("Rental status: " + sample.rentVehicle());
            final Vehicle found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final RentalException ex) {
            System.out.println("Validation error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String readString(final Scanner scanner, final String prompt, final String defaultValue) {
        System.out.print(prompt);
        final String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }

    private static int readInt(final Scanner scanner, final String prompt, final String defaultValue) {
        while (true) {
            System.out.print(prompt);
            final String input = scanner.nextLine().trim();
            final String effectiveValue = input.isEmpty() ? defaultValue : input;
            try {
                return Integer.parseInt(effectiveValue);
            } catch (final NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(final Scanner scanner, final String prompt, final String defaultValue) {
        while (true) {
            System.out.print(prompt);
            final String input = scanner.nextLine().trim();
            final String effectiveValue = input.isEmpty() ? defaultValue : input;
            try {
                return Double.parseDouble(effectiveValue);
            } catch (final NumberFormatException ex) {
                System.out.println("Please enter a valid decimal number.");
            }
        }
    }

    private static boolean readBoolean(final Scanner scanner, final String prompt, final String defaultValue) {
        while (true) {
            System.out.print(prompt);
            final String input = scanner.nextLine().trim();
            final String effectiveValue = input.isEmpty() ? defaultValue : input;
            if ("true".equalsIgnoreCase(effectiveValue) || "yes".equalsIgnoreCase(effectiveValue) || "y".equalsIgnoreCase(effectiveValue)) {
                return true;
            }
            if ("false".equalsIgnoreCase(effectiveValue) || "no".equalsIgnoreCase(effectiveValue) || "n".equalsIgnoreCase(effectiveValue)) {
                return false;
            }
            System.out.println("Please enter true/false or yes/no.");
        }
    }
}