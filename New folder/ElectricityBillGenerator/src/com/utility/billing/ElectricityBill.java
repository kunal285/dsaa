package com.utility.billing;


/**
 * Concrete entity that stores the project-specific data.
 */
public class ElectricityBill extends BillRecord implements Billable {
    private int units;
    private double rate;
    private double fixedCharge;


    public ElectricityBill(final String name, final int units, final double rate, final double fixedCharge) throws BillingException {
        super(name);
        if (units < 0) {             throw new BillingException("Units cannot be negative.");         }         if (rate < 0.0) {             throw new BillingException("Rate cannot be negative.");         }         if (fixedCharge < 0.0) {             throw new BillingException("Fixed charge cannot be negative.");         }
        this.units = units;
        this.rate = rate;
        this.fixedCharge = fixedCharge;

    }

    public int getUnits() {
        return units;
    }

    public void setUnits(final int units) throws BillingException {
        if (units < 0) {
            throw new BillingException("Units cannot be negative.");
        }
        this.units = units;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(final double rate) throws BillingException {
        if (rate < 0.0) {
            throw new BillingException("Rate cannot be negative.");
        }
        this.rate = rate;
    }

    public double getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(final double fixedCharge) throws BillingException {
        if (fixedCharge < 0.0) {
            throw new BillingException("Fixed charge cannot be negative.");
        }
        this.fixedCharge = fixedCharge;
    }

    @Override
    public double calculateBill() {
        return (units * rate) + fixedCharge;
    }

    @Override
    public String billSummary() {
        return getName() + " bill = " + calculateBill();
    }


    public String describe() {
        return getBasicInfo() + ", " + "units=" + units + ", " + "rate=" + rate + ", " + "fixedCharge=" + fixedCharge;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "ElectricityBill";
    }
}