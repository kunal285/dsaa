package com.feedback.system;

/**
 * Custom checked exception for validation errors.
 */
public class FeedbackException extends Exception {
    public FeedbackException(final String message) {
        super(message);
    }
}