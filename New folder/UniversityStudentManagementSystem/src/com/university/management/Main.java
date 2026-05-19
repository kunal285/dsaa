package com.university.management;

import java.util.Scanner;

/**
 * Main driver used to test the University Student Management System project.
 */
public class Main {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== University Student Management System ===");
            final String studentName = readString(scanner, "Enter student name [Demo Student]: ", "Demo Student");
            final int attendance = readInt(scanner, "Enter attendance percentage [82]: ", "82");
            final double familyIncome = readDouble(scanner, "Enter family income [250000]: ", "250000");

            final Student sample = new Student(studentName, attendance, 0.0, familyIncome);
            final Department department = new Department("Computer Science", "Dr. Mehta");

            final Course programming = new Course("Programming", 4, readDouble(scanner, "Programming marks [86]: ", "86"));
            final Course database = new Course("Database Systems", 3, readDouble(scanner, "Database marks [90]: ", "90"));
            final Course communication = new Course("Communication", 2, readDouble(scanner, "Communication marks [78]: ", "78"));

            sample.addCourse(programming);
            sample.addCourse(database);
            sample.addCourse(communication);
            department.addCourse(programming);
            department.addCourse(database);
            department.addCourse(communication);

            final StudentManager manager = new StudentManager();
            manager.add(sample);
            System.out.println("Stored record:");
            manager.printAll();
            System.out.println("Department summary: " + department);
            System.out.println("Calculated GPA: " + sample.calculateGpa());
            System.out.println("Exam eligible: " + sample.isExamEligible());
            System.out.println("Scholarship eligible: " + sample.isScholarshipEligible());
            final Student found = manager.findByName(sample.getName());
            if (found != null) {
                System.out.println("Search by name: " + found);
            }
        } catch (final UniversityException ex) {
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