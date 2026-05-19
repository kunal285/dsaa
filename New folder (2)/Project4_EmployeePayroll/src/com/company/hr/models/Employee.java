package com.company.hr.models;

import com.company.hr.exceptions.InvalidSalaryException;
import com.company.hr.exceptions.InvalidWorkingDaysException;
import com.company.hr.interfaces.Payable;

/**
 * Abstract base class for all employees
 */
public abstract class Employee implements Payable {
    private final String employeeId;
    private final String employeeName;
    private final String designation;
    private double baseSalary;
    private int workingDays;
    private static final int TOTAL_WORKING_DAYS = 30;

    /**
     * Constructor for Employee
     * @param employeeId unique employee identifier
     * @param employeeName employee name
     * @param designation employee designation
     * @param baseSalary base salary
     * @throws InvalidSalaryException if salary is invalid
     */
    public Employee(String employeeId, String employeeName, String designation, double baseSalary) 
            throws InvalidSalaryException {
        if (baseSalary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + baseSalary);
        }
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.workingDays = TOTAL_WORKING_DAYS;
    }

    /**
     * Set working days
     * @param workingDays number of working days
     * @throws InvalidWorkingDaysException if working days is invalid
     */
    public void setWorkingDays(int workingDays) throws InvalidWorkingDaysException {
        if (workingDays < 0 || workingDays > TOTAL_WORKING_DAYS) {
            throw new InvalidWorkingDaysException("Working days must be between 0 and " + TOTAL_WORKING_DAYS + 
                                                  ", received: " + workingDays);
        }
        this.workingDays = workingDays;
    }

    /**
     * Set base salary
     * @param baseSalary new base salary
     * @throws InvalidSalaryException if salary is invalid
     */
    public void setBaseSalary(double baseSalary) throws InvalidSalaryException {
        if (baseSalary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + baseSalary);
        }
        this.baseSalary = baseSalary;
    }

    /**
     * Calculate basic salary based on working days
     * @return calculated basic salary
     */
    protected double calculateBasicSalary() {
        return (baseSalary / TOTAL_WORKING_DAYS) * workingDays;
    }

    @Override
    public abstract double calculateSalary();

    @Override
    public String getEmployeeInfo() {
        return "Employee{" +
                "id='" + employeeId + '\'' +
                ", name='" + employeeName + '\'' +
                ", designation='" + designation + '\'' +
                ", baseSalary=" + baseSalary +
                ", workingDays=" + workingDays +
                '}';
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public static int getTotalWorkingDays() {
        return TOTAL_WORKING_DAYS;
    }
}
