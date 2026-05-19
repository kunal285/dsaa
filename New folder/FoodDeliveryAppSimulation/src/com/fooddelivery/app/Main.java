package com.fooddelivery.app;

import java.util.Scanner;

/**
 * Main driver used to test the Food Delivery App Simulation project.
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final DeliveryManager manager = new DeliveryManager();

        try {
            System.out.println("=== Food Delivery App Simulation ===");
            final String name = readString(scanner, "Enter name [Demo]: ", "Demo");
            final String restaurantName = readString(scanner, "Enter restaurant name [City Bites]: ", "City Bites");             final double orderTotal = readDouble(scanner, "Enter order total [850]: ", "850");             final boolean delivered = readBoolean(scanner, "Is the order already delivered? [false]: ", "false");
            final FoodOrder sample = new FoodOrder(name, restaurantName, orderTotal, delivered);

            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Delivery charge: " + sample.deliveryCharge());
            System.out.println("Delivery status: " + sample.deliverOrder());
            final FoodOrder found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final FoodDeliveryException ex) {
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