package com.shopping.cart;

import java.util.Scanner;

/**
 * Main driver used to test the Online Shopping System project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final Cart cart = new Cart();

            System.out.println("=== Online Shopping System ===");
            final String name = readString(scanner, "Enter product name [Demo Product]: ", "Demo Product");
            final double price = readDouble(scanner, "Enter item price [499.99]: ", "499.99");
            final int quantity = readInt(scanner, "Enter quantity [2]: ", "2");
            final double discountRate = readDouble(scanner, "Enter discount rate [10]: ", "10");

            final Product sample = new Product(name, price, quantity, discountRate);
            cart.addProduct(sample);
            final Order order = new Order("Checkout", sample);

            System.out.println("Stored product:");
            cart.printAll();
            System.out.println("Cart total: " + cart.calculateCartTotal());
            System.out.println("Checkout order: " + order);
            final Product found = cart.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final ShoppingException ex) {
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