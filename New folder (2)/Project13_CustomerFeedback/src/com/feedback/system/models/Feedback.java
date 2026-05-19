package com.feedback.system.models;

import java.time.LocalDateTime;

public final class Feedback {
    private final String feedbackId;
    private final String customerId;
    private final int rating;
    private final String review;
    private final LocalDateTime feedbackDate;
    private static int feedbackCounter = 0;

    public Feedback(String customerId, int rating, String review) {
        this.feedbackId = "FB_" + (++feedbackCounter);
        this.customerId = customerId;
        this.rating = rating;
        this.review = review;
        this.feedbackDate = LocalDateTime.now();
    }

    public int getRating() { return rating; }
    public String getReview() { return review; }
    public String getFeedbackId() { return feedbackId; }
}
