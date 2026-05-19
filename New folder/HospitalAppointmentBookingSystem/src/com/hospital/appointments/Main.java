package com.hospital.appointments;

import java.util.Scanner;

/**
 * Main driver used to test the Hospital Appointment Booking System project.
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final AppointmentManager manager = new AppointmentManager();

        try {
            System.out.println("=== Hospital Appointment Booking System ===");
            final String name = readString(scanner, "Enter name [Demo]: ", "Demo");
            final String doctorName = readString(scanner, "Enter doctor name [Dr. Smith]: ", "Dr. Smith");             final String appointmentDate = readString(scanner, "Enter appointment date [2026-05-20]: ", "2026-05-20");             final boolean urgent = readBoolean(scanner, "Is the appointment urgent? [false]: ", "false");
            final Appointment sample = new Appointment(name, doctorName, appointmentDate, urgent);

            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Schedule result: " + sample.scheduleAppointment());
            System.out.println("Summary: " + sample.appointmentSummary());
            final Appointment found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final AppointmentException ex) {
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