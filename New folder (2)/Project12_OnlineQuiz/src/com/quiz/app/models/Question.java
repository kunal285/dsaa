package com.quiz.app.models;

public final class Question {
    private final int questionId;
    private final String questionText;
    private final String correctAnswer;

    public Question(int questionId, String questionText, String correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionId() { return questionId; }
    public String getQuestionText() { return questionText; }
    public String getCorrectAnswer() { return correctAnswer; }

    public boolean isAnswerCorrect(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
