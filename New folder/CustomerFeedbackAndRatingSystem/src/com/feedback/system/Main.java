package com.feedback.system;

import java.util.Scanner;

/**
 * Main driver used to test the Customer Feedback and Rating System project.
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final FeedbackManager manager = new FeedbackManager();

        try {
            System.out.println("=== Customer Feedback and Rating System ===");
            final String name = readString(scanner, "Enter name [Demo]: ", "Demo");
            final int rating = readInt(scanner, "Enter rating [5]: ", "5");             final String comments = readString(scanner, "Enter comments [Great service]: ", "Great service");             final boolean resolved = readBoolean(scanner, "Is feedback resolved? [false]: ", "false");
            final CustomerFeedback sample = new CustomerFeedback(name, rating, comments, resolved);

            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Review summary: " + sample.reviewSummary());
            System.out.println("Positive review: " + sample.isPositiveReview());
            final CustomerFeedback found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final FeedbackException ex) {
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