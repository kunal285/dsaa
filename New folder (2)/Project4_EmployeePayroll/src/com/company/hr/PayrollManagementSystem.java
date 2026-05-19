package com.company.hr;

import com.company.hr.exceptions.InvalidSalaryException;
import com.company.hr.exceptions.InvalidWorkingDaysException;
import com.company.hr.models.Clerk;
import com.company.hr.models.Employee;
import com.company.hr.models.Manager;

/**
 * Main class for Employee Payroll Management System
 */
public class PayrollManagementSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Employee Payroll Management System ===\n");

            // Create employees
            Manager manager1 = new Manager("E001", "Vikram Singhdev", 50000.0, 10);
            Manager manager2 = new Manager("E002", "Neha Verma", 45000.0, 8, 0.20);
            Clerk clerk1 = new Clerk("E003", "Rajesh Kumar", 25000.0);
            Clerk clerk2 = new Clerk("E004", "Priya Patel", 22000.0, 0.12);

            // Store employees in array
            Employee[] employees = {manager1, manager2, clerk1, clerk2};

            // Display employee details
            System.out.println("--- Employee Details ---\n");
            for (Employee emp : employees) {
                System.out.println(emp.getEmployeeInfo());
                System.out.println();
            }

            // Calculate and display salary
            System.out.println("--- Salary Calculation (Full Month) ---\n");
            double totalPayroll = 0;
            for (Employee emp : employees) {
                System.out.println(emp.getSalaryDetails());
                System.out.println();
                totalPayroll += emp.calculateSalary();
            }
            System.out.println("Total Monthly Payroll: Rs. " + String.format("%.2f", totalPayroll));

            // Update working days and recalculate
            System.out.println("\n--- Updating Working Days ---");
            manager1.setWorkingDays(25);
            System.out.println("✓ Updated " + manager1.getEmployeeName() + " working days to 25");

            clerk1.setWorkingDays(28);
            System.out.println("✓ Updated " + clerk1.getEmployeeName() + " working days to 28");

            System.out.println("\n--- Salary After Working Days Update ---\n");
            totalPayroll = 0;
            for (Employee emp : employees) {
                System.out.println(emp.getSalaryDetails());
                System.out.println();
                totalPayroll += emp.calculateSalary();
            }
            System.out.println("Total Monthly Payroll: Rs. " + String.format("%.2f", totalPayroll));

            // Test invalid operations
            System.out.println("\n--- Testing Invalid Operations ---");
            testInvalidSalary();
            testInvalidWorkingDays();

        } catch (InvalidSalaryException | InvalidWorkingDaysException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testInvalidSalary() {
        try {
            System.out.println("Attempting to create manager with negative salary...");
            Manager testManager = new Manager("E099", "Test Manager", -50000.0, 5);
            testManager.toString(); // referenced to silence analyzer
        } catch (InvalidSalaryException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidWorkingDays() {
        try {
            System.out.println("Attempting to set invalid working days (40)...");
            Manager manager = new Manager("E100", "Test", 50000.0, 5);
            manager.setWorkingDays(40);
        } catch (InvalidSalaryException | InvalidWorkingDaysException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
