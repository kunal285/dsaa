package com.company.hr.models;

import com.company.hr.exceptions.InvalidSalaryException;

/**
 * Manager class extending Employee
 */
public final class Manager extends Employee {
    private final double incentivePercentage;
    private final int teamSize;
    private static final double STANDARD_INCENTIVE = 0.15; // 15% incentive

    /**
     * Constructor for Manager
     * @param employeeId unique employee identifier
     * @param employeeName employee name
     * @param baseSalary base salary
     * @param teamSize size of managed team
     * @throws InvalidSalaryException if salary is invalid
     */
    public Manager(String employeeId, String employeeName, double baseSalary, int teamSize) 
            throws InvalidSalaryException {
        super(employeeId, employeeName, "Manager", baseSalary);
        this.teamSize = teamSize;
        this.incentivePercentage = STANDARD_INCENTIVE;
    }

    /**
     * Constructor with custom incentive
     * @param employeeId unique employee identifier
     * @param employeeName employee name
     * @param baseSalary base salary
     * @param teamSize size of managed team
     * @param incentivePercentage custom incentive percentage
     * @throws InvalidSalaryException if salary is invalid
     */
    public Manager(String employeeId, String employeeName, double baseSalary, int teamSize, double incentivePercentage) 
            throws InvalidSalaryException {
        super(employeeId, employeeName, "Manager", baseSalary);
        this.teamSize = teamSize;
        this.incentivePercentage = incentivePercentage;
    }

    @Override
    public double calculateSalary() {
        double basicSalary = calculateBasicSalary();
        double incentive = basicSalary * incentivePercentage;
        return basicSalary + incentive;
    }

    @Override
    public String getSalaryDetails() {
        double basicSalary = calculateBasicSalary();
        double incentive = basicSalary * incentivePercentage;
        double totalSalary = calculateSalary();
        
        return "Manager Salary Details:" +
                "\n  Employee ID: " + getEmployeeId() +
                "\n  Name: " + getEmployeeName() +
                "\n  Team Size: " + teamSize +
                "\n  Working Days: " + getWorkingDays() + "/" + getTotalWorkingDays() +
                "\n  Basic Salary: Rs. " + String.format("%.2f", basicSalary) +
                "\n  Incentive (" + (incentivePercentage * 100) + "%): Rs. " + String.format("%.2f", incentive) +
                "\n  Total Salary: Rs. " + String.format("%.2f", totalSalary);
    }

    public int getTeamSize() {
        return teamSize;
    }

    public double getIncentivePercentage() {
        return incentivePercentage;
    }
}
