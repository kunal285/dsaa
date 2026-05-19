package com.quiz.app;


/**
 * Concrete entity that stores the project-specific data.
 */
public class QuizAttempt extends QuizRecord implements Scorable {
    private int totalQuestions;
    private int correctAnswers;


    public QuizAttempt(final String name, final int totalQuestions, final int correctAnswers) throws QuizException {
        super(name);
        if (totalQuestions < 1) {             throw new QuizException("Total questions must be at least 1.");         }         if (correctAnswers < 0 || correctAnswers > totalQuestions) {             throw new QuizException("Correct answers must be between 0 and total questions.");         }
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;

    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(final int totalQuestions) throws QuizException {
        if (totalQuestions < 1) {
            throw new QuizException("Total questions must be at least 1.");
        }
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(final int correctAnswers) throws QuizException {
        if (correctAnswers < 0 || correctAnswers > totalQuestions) {
            throw new QuizException("Correct answers must be between 0 and total questions.");
        }
        this.correctAnswers = correctAnswers;
    }

    @Override
    public int calculateScore() {
        return correctAnswers * 10;
    }

    @Override
    public double calculatePercentage() {
        return totalQuestions == 0 ? 0.0 : (correctAnswers * 100.0) / totalQuestions;
    }


    public String describe() {
        return getBasicInfo() + ", " + "totalQuestions=" + totalQuestions + ", " + "correctAnswers=" + correctAnswers;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "QuizAttempt";
    }
}