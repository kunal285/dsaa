package com.quiz.app;

/**
 * Custom checked exception for validation errors.
 */
public class QuizException extends Exception {
    public QuizException(final String message) {
        super(message);
    }
}