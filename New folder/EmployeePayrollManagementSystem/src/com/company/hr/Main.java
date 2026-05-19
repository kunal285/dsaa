package com.company.hr;

import java.util.Scanner;

/**
 * Main driver used to test the Employee Payroll Management System project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final PayrollManager manager = new PayrollManager();

            System.out.println("=== Employee Payroll Management System ===");
            final String name = readString(scanner, "Enter employee name [Demo]: ", "Demo");
            final double basicPay = readDouble(scanner, "Enter basic pay [50000]: ", "50000");
            final double allowance = readDouble(scanner, "Enter allowance [10000]: ", "10000");
            final int workingDays = readInt(scanner, "Enter working days [30]: ", "30");

            final Employee sample = new Manager(name, basicPay, allowance, workingDays);
            final Employee clerk = new Clerk("Assistant", 32000.0, 5000.0, 24);

            manager.add(sample);
            manager.add(clerk);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Calculated pay: " + sample.calculatePay());
            System.out.println("Pay slip: " + sample.paySlip());
            System.out.println("Clerk pay: " + clerk.calculatePay());
            final Employee found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final PayrollException ex) {
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