package com.railway.reservation;

import java.util.Scanner;

/**
 * Main driver used to test the Railway Reservation System project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final ReservationManager manager = new ReservationManager();

            System.out.println("=== Railway Reservation System ===");
            final String passengerName = readString(scanner, "Enter passenger name [Demo Passenger]: ", "Demo Passenger");
            final int age = readInt(scanner, "Enter passenger age [28]: ", "28");
            final String gender = readString(scanner, "Enter passenger gender [M]: ", "M");
            final String trainName = readString(scanner, "Enter train name [Express]: ", "Express");
            final String trainNumber = readString(scanner, "Enter train number [TR-101]: ", "TR-101");
            final int totalSeats = readInt(scanner, "Enter total seats [50]: ", "50");
            final double farePerSeat = readDouble(scanner, "Enter fare per seat [250.0]: ", "250.0");
            final int seatCount = readInt(scanner, "Enter seat count [1]: ", "1");

            final Passenger passenger = new Passenger(passengerName, age, gender);
            final Train train = new Train(trainName, trainNumber, totalSeats, farePerSeat);
            final Ticket sample = new Ticket("Ticket-1", train, passenger, seatCount, true);

            manager.add(sample);
            System.out.println("Stored ticket:");
            manager.printAll();
            System.out.println("Reserve status: " + sample.reserve());
            System.out.println("Details: " + sample.reservationDetails());
            System.out.println("Calculated fare: " + sample.calculateFare());
            final Ticket found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final RailwayException ex) {
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

}