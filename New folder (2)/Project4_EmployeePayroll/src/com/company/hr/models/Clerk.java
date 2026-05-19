package com.company.hr.models;

import com.company.hr.exceptions.InvalidSalaryException;

/**
 * Clerk class extending Employee
 */
public final class Clerk extends Employee {
    private final double bonusPercentage;
    private static final double STANDARD_BONUS = 0.10; // 10% bonus

    /**
     * Constructor for Clerk
     * @param employeeId unique employee identifier
     * @param employeeName employee name
     * @param baseSalary base salary
     * @throws InvalidSalaryException if salary is invalid
     */
    public Clerk(String employeeId, String employeeName, double baseSalary) 
            throws InvalidSalaryException {
        super(employeeId, employeeName, "Clerk", baseSalary);
        this.bonusPercentage = STANDARD_BONUS;
    }

    /**
     * Constructor with custom bonus
     * @param employeeId unique employee identifier
     * @param employeeName employee name
     * @param baseSalary base salary
     * @param bonusPercentage custom bonus percentage
     * @throws InvalidSalaryException if salary is invalid
     */
    public Clerk(String employeeId, String employeeName, double baseSalary, double bonusPercentage) 
            throws InvalidSalaryException {
        super(employeeId, employeeName, "Clerk", baseSalary);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateSalary() {
        double basicSalary = calculateBasicSalary();
        double bonus = basicSalary * bonusPercentage;
        return basicSalary + bonus;
    }

    @Override
    public String getSalaryDetails() {
        double basicSalary = calculateBasicSalary();
        double bonus = basicSalary * bonusPercentage;
        double totalSalary = calculateSalary();
        
        return "Clerk Salary Details:" +
                "\n  Employee ID: " + getEmployeeId() +
                "\n  Name: " + getEmployeeName() +
                "\n  Working Days: " + getWorkingDays() + "/" + getTotalWorkingDays() +
                "\n  Basic Salary: Rs. " + String.format("%.2f", basicSalary) +
                "\n  Bonus (" + (bonusPercentage * 100) + "%): Rs. " + String.format("%.2f", bonus) +
                "\n  Total Salary: Rs. " + String.format("%.2f", totalSalary);
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }
}
