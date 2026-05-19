package com.feedback.system;

import com.feedback.system.models.Customer;
import com.feedback.system.models.Feedback;
import com.feedback.system.models.Product;

public class FeedbackSystem {
    public static void main(String[] args) {
        System.out.println("=== Customer Feedback and Rating System ===\n");

        Product laptop = new Product("P001", "Laptop Pro");
        Product mouse = new Product("P002", "Wireless Mouse");

        laptop.addFeedback(new Feedback("C001", 5, "Excellent product!"));
        laptop.addFeedback(new Feedback("C002", 4, "Good value"));
        laptop.addFeedback(new Feedback("C003", 3, "Average"));

        mouse.addFeedback(new Feedback("C004", 5, "Perfect!"));
        mouse.addFeedback(new Feedback("C005", 4, "Good"));

        System.out.println("--- Product Ratings ---");
        System.out.println(laptop.getProductName() + " - Average Rating: " + 
                         String.format("%.2f", laptop.getAverageRating()) + "/5");
        System.out.println(mouse.getProductName() + " - Average Rating: " + 
                         String.format("%.2f", mouse.getAverageRating()) + "/5");
    }
}
