package com.feedback.system.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Product {
    private final String productId;
    private final String productName;
    private final List<Feedback> feedbacks;
    private double averageRating;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
        this.feedbacks = new ArrayList<>();
        this.averageRating = 0;
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
        calculateAverageRating();
    }

    private void calculateAverageRating() {
        if (feedbacks.isEmpty()) {
            this.averageRating = 0;
            return;
        }
        double sum = feedbacks.stream().mapToDouble(Feedback::getRating).sum();
        this.averageRating = sum / feedbacks.size();
    }

    public double getAverageRating() { return averageRating; }
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getFeedbackCount() { return feedbacks.size(); }
}
