package com.company.hr;


/**
 * Concrete entity that stores the project-specific data.
 */
public class Employee extends EmployeeRecord implements Payable {
    private static final double OVERTIME_RATE = 100.0;

    private double basicPay;
    private double allowance;
    private int workingDays;


    public Employee(final String name, final double basicPay, final double allowance, final int workingDays) throws PayrollException {
        super(name);
        if (basicPay < 0.0) {             throw new PayrollException("Basic pay cannot be negative.");         }         if (allowance < 0.0) {             throw new PayrollException("Allowance cannot be negative.");         }         if (workingDays < 0) {             throw new PayrollException("Working days cannot be negative.");         }
        this.basicPay = basicPay;
        this.allowance = allowance;
        this.workingDays = workingDays;

    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(final double basicPay) throws PayrollException {
        if (basicPay < 0.0) {
            throw new PayrollException("Basic pay cannot be negative.");
        }
        this.basicPay = basicPay;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(final double allowance) throws PayrollException {
        if (allowance < 0.0) {
            throw new PayrollException("Allowance cannot be negative.");
        }
        this.allowance = allowance;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(final int workingDays) throws PayrollException {
        if (workingDays < 0) {
            throw new PayrollException("Working days cannot be negative.");
        }
        this.workingDays = workingDays;
    }

    @Override
    public double calculatePay() {
        return basicPay + allowance + (workingDays * OVERTIME_RATE);
    }

    @Override
    public String paySlip() {
        return "Pay slip for " + getName() + ": " + calculatePay();
    }


    @Override
    public String describe() {
        return getBasicInfo() + ", basicPay=" + basicPay + ", allowance=" + allowance + ", workingDays=" + workingDays;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "Employee";
    }
}