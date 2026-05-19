package com.company.hr;

/**
 * Manager with an additional incentive.
 */
public class Manager extends Employee {
    private static final double MANAGER_BONUS = 15000.0;

    public Manager(final String name, final double basicPay, final double allowance, final int workingDays) throws PayrollException {
        super(name, basicPay, allowance, workingDays);
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + MANAGER_BONUS;
    }

    @Override
    public String getCategory() {
        return "Manager";
    }
}