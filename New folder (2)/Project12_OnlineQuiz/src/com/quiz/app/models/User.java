package com.quiz.app.models;

import com.quiz.app.exceptions.QuizException;
import com.quiz.app.interfaces.Scorable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class User implements Scorable {
    private final String userId;
    private final String userName;
    private final List<Question> questions;
    private final Map<Integer, String> answers;

    public User(String userId, String userName) throws QuizException {
        if (userId == null || userId.isEmpty()) {
            throw new QuizException("User ID cannot be empty");
        }
        this.userId = userId;
        this.userName = userName;
        this.questions = new ArrayList<>();
        this.answers = new HashMap<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void submitAnswer(int questionIndex, String answer) {
        if (questionIndex >= 0 && questionIndex < questions.size()) {
            answers.put(questionIndex, answer);
        }
    }

    @Override
    public double calculateScore() {
        int correct = 0;
        for (int i = 0; i < questions.size(); i++) {
            String answer = answers.get(i);
            if (answer != null && questions.get(i).isAnswerCorrect(answer)) {
                correct++;
            }
        }
        return (double) correct / questions.size() * 100;
    }

    @Override
    public int getTotalQuestions() {
        return questions.size();
    }

    public String getUserId() { return userId; }
    public String getUserName() { return userName; }
}
