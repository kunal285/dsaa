package com.quiz.app.interfaces;

public interface Scorable {
    void submitAnswer(int questionIndex, String answer);
    double calculateScore();
    int getTotalQuestions();
}
