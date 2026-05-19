package com.finance.loans;

import com.finance.loans.models.Applicant;
import com.finance.loans.models.Loan;

public class LoanEligibilityChecker {
    public static void main(String[] args) {
        System.out.println("=== Loan Eligibility Checker ===\n");
        
        Applicant applicant = new Applicant("APP001", "Rajesh Kumar", 35, 500000, 750);
        Loan loan = new Loan(200000, 8.5);
        
        boolean eligible = checkEligibility(applicant);
        
        System.out.println("✓ Applicant: " + applicant.getApplicantName());
        System.out.println("  Age: " + applicant.getAge());
        System.out.println("  Annual Income: Rs. " + applicant.getAnnualIncome());
        System.out.println("  Credit Score: " + applicant.getCreditScore());
        System.out.println("\n✓ Loan Requested: Rs. " + loan.getLoanAmount());
        System.out.println("  Interest Rate: " + loan.getInterestRate() + "%");
        System.out.println("  Eligible: " + (eligible ? "YES" : "NO"));
    }

    private static boolean checkEligibility(Applicant applicant) {
        return applicant.getAge() >= 21 && 
               applicant.getAge() <= 65 &&
               applicant.getAnnualIncome() >= 300000 &&
               applicant.getCreditScore() >= 650;
    }
}
