package com.company.hr;

/**
 * Clerk employee with a smaller incentive.
 */
public class Clerk extends Employee {
    private static final double CLERK_BONUS = 5000.0;

    public Clerk(final String name, final double basicPay, final double allowance, final int workingDays) throws PayrollException {
        super(name, basicPay, allowance, workingDays);
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + CLERK_BONUS;
    }

    @Override
    public String getCategory() {
        return "Clerk";
    }
}