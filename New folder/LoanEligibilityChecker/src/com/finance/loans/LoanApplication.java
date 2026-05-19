package com.finance.loans;


/**
 * Concrete entity that stores the project-specific data.
 */
public class LoanApplication extends ApplicantRecord implements Eligible {
    private double income;
    private double existingEmi;
    private double loanAmount;


    public LoanApplication(final String name, final double income, final double existingEmi, final double loanAmount) throws LoanException {
        super(name);
        if (income < 0.0) {             throw new LoanException("Income cannot be negative.");         }         if (existingEmi < 0.0) {             throw new LoanException("Existing EMI cannot be negative.");         }         if (loanAmount < 0.0) {             throw new LoanException("Loan amount cannot be negative.");         }
        this.income = income;
        this.existingEmi = existingEmi;
        this.loanAmount = loanAmount;

    }

    public double getIncome() {
        return income;
    }

    public void setIncome(final double income) throws LoanException {
        if (income < 0.0) {
            throw new LoanException("Income cannot be negative.");
        }
        this.income = income;
    }

    public double getExistingEmi() {
        return existingEmi;
    }

    public void setExistingEmi(final double existingEmi) throws LoanException {
        if (existingEmi < 0.0) {
            throw new LoanException("Existing EMI cannot be negative.");
        }
        this.existingEmi = existingEmi;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(final double loanAmount) throws LoanException {
        if (loanAmount < 0.0) {
            throw new LoanException("Loan amount cannot be negative.");
        }
        this.loanAmount = loanAmount;
    }

    @Override
    public boolean isEligible() {
        return income >= (existingEmi * 3.0) && loanAmount <= (income * 20.0);
    }

    @Override
    public String eligibilitySummary() {
        return isEligible() ? "Applicant is eligible for the loan." : "Applicant is not eligible for the loan.";
    }


    public String describe() {
        return getBasicInfo() + ", " + "income=" + income + ", " + "existingEmi=" + existingEmi + ", " + "loanAmount=" + loanAmount;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "LoanApplication";
    }
}