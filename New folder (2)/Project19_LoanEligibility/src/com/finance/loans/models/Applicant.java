package com.finance.loans.models;

public final class Applicant {
    private final String applicantId;
    private final String applicantName;
    private final int age;
    private final double annualIncome;
    private final int creditScore;

    public Applicant(String applicantId, String applicantName, int age, double annualIncome, int creditScore) {
        this.applicantId = applicantId;
        this.applicantName = applicantName;
        this.age = age;
        this.annualIncome = annualIncome;
        this.creditScore = creditScore;
    }

    public int getAge() { return age; }
    public double getAnnualIncome() { return annualIncome; }
    public int getCreditScore() { return creditScore; }
    public String getApplicantName() { return applicantName; }
}

class Loan {
    private final String loanId;
    private final double loanAmount;
    private final double interestRate;
    private static int loanCounter = 0;

    public Loan(double loanAmount, double interestRate) {
        this.loanId = "LN_" + (++loanCounter);
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    public double getLoanAmount() { return loanAmount; }
    public double getInterestRate() { return interestRate; }
    public String getLoanId() { return loanId; }
}
