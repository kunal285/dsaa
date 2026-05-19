package com.finance.loans;

/**
 * Contract for Eligible behavior.
 */
public interface Eligible {
    boolean isEligible();
    String eligibilitySummary();
}