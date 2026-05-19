package com.company.hr.interfaces;

/**
 * Interface for payable employees
 */
public interface Payable {
    /**
     * Calculate salary
     * @return calculated salary
     */
    double calculateSalary();

    /**
     * Get salary details as string
     * @return salary details
     */
    String getSalaryDetails();

    /**
     * Get employee information
     * @return employee info
     */
    String getEmployeeInfo();
}
