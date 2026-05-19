package com.finance.loans;

import java.util.Scanner;

/**
 * Main driver used to test the Loan Eligibility Checker project.
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LoanManager manager = new LoanManager();

        try {
            System.out.println("=== Loan Eligibility Checker ===");
            final String name = readString(scanner, "Enter name [Demo]: ", "Demo");
            final double income = readDouble(scanner, "Enter monthly income [60000]: ", "60000");             final double existingEmi = readDouble(scanner, "Enter existing EMI [10000]: ", "10000");             final double loanAmount = readDouble(scanner, "Enter loan amount [500000]: ", "500000");
            final LoanApplication sample = new LoanApplication(name, income, existingEmi, loanAmount);

            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Eligibility: " + sample.isEligible());
            System.out.println("Summary: " + sample.eligibilitySummary());
            final LoanApplication found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final LoanException ex) {
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