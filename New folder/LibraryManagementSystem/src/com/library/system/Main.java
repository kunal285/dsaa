package com.library.system;

import java.util.Scanner;

/**
 * Main driver used to test the Library Management System project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Library Management System ===");
            final String bookTitle = readString(scanner, "Enter book title [The Alchemist]: ", "The Alchemist");
            final String author = readString(scanner, "Enter author [Paulo Coelho]: ", "Paulo Coelho");
            final int borrowedDays = readInt(scanner, "Enter borrowed days [14]: ", "14");
            final boolean borrowed = readBoolean(scanner, "Is the book currently borrowed? [false]: ", "false");
            final Book sample = new Book(bookTitle, author, borrowedDays, borrowed);
            final Member member = new Member("Asha", "MEM-1001");
            final Librarian librarian = new Librarian("Rita", "LIB-2001", "EMP-01");

            System.out.println("Stored book:");
            System.out.println(sample);
            System.out.println(member);
            System.out.println(librarian);
            System.out.println(member.issueBook(sample));
            System.out.println(librarian.returnBook(sample, 3));
            System.out.println("Fine for 3 days late: " + sample.calculateFine(3));
            final LibraryManager manager = new LibraryManager();
            manager.add(new BookItem(sample.getName(), sample.getAuthor(), sample.getBorrowedDays(), sample.isBorrowed()));
            final BookItem found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final LibraryException ex) {
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