package com.university.management.interfaces;

/**
 * Interface for checking scholarship eligibility
 */
public interface ScholarshipEligibility {
    /**
     * Check if student is eligible for scholarship
     * @return true if eligible, false otherwise
     */
    boolean isEligibleForScholarship();

    /**
     * Get scholarship amount if eligible
     * @return scholarship amount
     */
    double getScholarshipAmount();

    /**
     * Get scholarship eligibility message
     * @return eligibility status message
     */
    String getScholarshipMessage();
}
