package com.inventory.stock;

import java.util.Scanner;

/**
 * Main driver used to test the Inventory Management System project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Inventory Management System ===");
            final String name = readString(scanner, "Enter warehouse name [Central Warehouse]: ", "Central Warehouse");
            final String location = readString(scanner, "Enter warehouse location [Bengaluru]: ", "Bengaluru");
            final String itemName = readString(scanner, "Enter item name [Laptop]: ", "Laptop");
            final String itemCode = readString(scanner, "Enter item code [ITM-1001]: ", "ITM-1001");
            final int quantity = readInt(scanner, "Enter quantity [50]: ", "50");
            final double unitPrice = readDouble(scanner, "Enter unit price [99.99]: ", "99.99");
            final int reorderLevel = readInt(scanner, "Enter reorder level [10]: ", "10");

            final Warehouse warehouse = new Warehouse(name, location);
            final Item sample = new Item(itemName, itemCode, quantity, unitPrice, reorderLevel);

            warehouse.getInventory().addItem(sample);
            System.out.println("Stored warehouse:");
            System.out.println(warehouse);
            warehouse.getInventory().printAll();
            System.out.println(sample.stockStatus());
            System.out.println(warehouse.reorderAlert(sample));

            final Item duplicate = new Item("Duplicate", itemCode, 5, 10.0, 2);
            try {
                warehouse.getInventory().addItem(duplicate);
            } catch (final InventoryException ex) {
                System.out.println("Duplicate check: " + ex.getMessage());
            }

            try {
                sample.removeStock(quantity + 1);
            } catch (final IllegalArgumentException ex) {
                System.out.println("Stock underflow check: " + ex.getMessage());
            }
        } catch (final InventoryException ex) {
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