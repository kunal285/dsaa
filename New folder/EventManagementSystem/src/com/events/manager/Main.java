package com.events.manager;

import java.util.Scanner;

/**
 * Main driver used to test the Event Management System project.
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final EventManager manager = new EventManager();

        try {
            System.out.println("=== Event Management System ===");
            final String name = readString(scanner, "Enter name [Demo]: ", "Demo");
            final String eventDate = readString(scanner, "Enter event date [2026-06-01]: ", "2026-06-01");             final int capacity = readInt(scanner, "Enter capacity [100]: ", "100");             final int attendees = readInt(scanner, "Enter attendees [80]: ", "80");
            final EventSchedule sample = new EventSchedule(name, eventDate, capacity, attendees);

            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Schedule result: " + sample.scheduleEvent());
            System.out.println("Status: " + sample.eventStatus());
            final EventSchedule found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final EventException ex) {
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