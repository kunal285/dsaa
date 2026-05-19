package com.quiz.app;

import com.quiz.app.exceptions.QuizException;
import com.quiz.app.models.Question;
import com.quiz.app.models.User;

public class OnlineQuizSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Online Quiz Management System ===\n");

            User user = new User("U001", "Rajesh Kumar");
            user.addQuestion(new Question(1, "What is the capital of India?", "Delhi"));
            user.addQuestion(new Question(2, "Java was developed by?", "Sun"));
            user.addQuestion(new Question(3, "Which is the largest planet?", "Jupiter"));

            System.out.println("--- Quiz Questions ---");
            System.out.println("Total Questions: " + user.getTotalQuestions());

            System.out.println("\n--- Submitting Answers ---");
            user.submitAnswer(0, "Delhi");
            System.out.println("✓ Answered Question 1");
            user.submitAnswer(1, "Sun");
            System.out.println("✓ Answered Question 2");
            user.submitAnswer(2, "Saturn");
            System.out.println("✓ Answered Question 3 (Incorrect)");

            System.out.println("\n--- Score ---");
            System.out.println("Score: " + String.format("%.2f", user.calculateScore()) + "%");

        } catch (QuizException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
