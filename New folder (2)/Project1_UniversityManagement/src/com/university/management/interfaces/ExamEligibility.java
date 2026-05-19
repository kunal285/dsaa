package com.university.management.interfaces;

/**
 * Interface for checking exam eligibility
 */
public interface ExamEligibility {
    /**
     * Check if student is eligible for exam
     * @return true if eligible, false otherwise
     */
    boolean isEligibleForExam();

    /**
     * Get eligibility message
     * @return eligibility status message
     */
    String getEligibilityMessage();
}
