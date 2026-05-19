package com.airline.booking;

import java.util.Scanner;

/**
 * Main driver used to test the Airline Ticketing System project.
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final AirlineManager manager = new AirlineManager();

        try {
            System.out.println("=== Airline Ticketing System ===");
            final String name = readString(scanner, "Enter name [Demo]: ", "Demo");
            final String flightNumber = readString(scanner, "Enter flight number [AI-204]: ", "AI-204");             final String seatNumber = readString(scanner, "Enter seat number [12A]: ", "12A");             final boolean checkedIn = readBoolean(scanner, "Already checked in? [false]: ", "false");
            final FlightBooking sample = new FlightBooking(name, flightNumber, seatNumber, checkedIn);

            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Check-in result: " + sample.checkIn());
            System.out.println("Boarding pass: " + sample.boardingPass());
            final FlightBooking found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final AirlineException ex) {
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

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
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