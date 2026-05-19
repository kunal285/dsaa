package com.parcel.tracking;

import java.util.Scanner;

/**
 * Main driver used to test the Parcel Tracking System project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final TrackingManager manager = new TrackingManager();

            System.out.println("=== Parcel Tracking System ===");
            final String name = readString(scanner, "Enter parcel name [Demo]: ", "Demo");
            final String trackingNumber = readString(scanner, "Enter tracking number [PKG12345]: ", "PKG12345");
            final String currentStatus = readString(scanner, "Enter current status [In Transit]: ", "In Transit");
            final boolean priority = readBoolean(scanner, "Is it priority parcel? [false]: ", "false");
            final int distanceUnits = readInt(scanner, "Enter distance units [14]: ", "14");

            final Location location = new Location("Checkpoint-1", "Bengaluru", "Karnataka", "560001");
            final Courier courier = new Courier("Ravi", "CR-01", 4);
            final Parcel sample = new Parcel(name, trackingNumber, currentStatus, priority, location, courier);

            manager.add(sample);
            System.out.println("Stored parcel:");
            manager.printAll();
            System.out.println("Track result: " + sample.track());
            System.out.println("Predicted delivery days: " + sample.predictDeliveryDays(distanceUnits));
            final Parcel found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final ParcelException ex) {
            System.out.println("Validation error: " + ex.getMessage());
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