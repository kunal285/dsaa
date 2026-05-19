package com.feedback.system;

/**
 * Contract for Reviewable behavior.
 */
public interface Reviewable {
    String reviewSummary();
    boolean isPositiveReview();
}