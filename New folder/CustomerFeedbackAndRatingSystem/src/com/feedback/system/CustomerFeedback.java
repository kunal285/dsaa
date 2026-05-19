package com.feedback.system;


/**
 * Concrete entity that stores the project-specific data.
 */
public class CustomerFeedback extends FeedbackRecord implements Reviewable {
    private int rating;
    private String comments;
    private boolean resolved;


    public CustomerFeedback(final String name, final int rating, final String comments, final boolean resolved) throws FeedbackException {
        super(name);
        if (rating < 1 || rating > 5) {             throw new FeedbackException("Rating must be between 1 and 5.");         }         if (comments == null || comments.trim().isEmpty()) {             throw new FeedbackException("Comments cannot be blank.");         }
        this.rating = rating;
        this.comments = comments;
        this.resolved = resolved;

    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) throws FeedbackException {
        if (rating < 1 || rating > 5) {
            throw new FeedbackException("Rating must be between 1 and 5.");
        }
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(final String comments) throws FeedbackException {
        if (comments == null || comments.trim().isEmpty()) {
            throw new FeedbackException("Comments cannot be blank.");
        }
        this.comments = comments;
    }

    public boolean getResolved() {
        return resolved;
    }

    public void setResolved(final boolean resolved) throws FeedbackException {
        this.resolved = resolved;
    }

    @Override
    public String reviewSummary() {
        return getName() + ": " + comments + " (Rating=" + rating + ")";
    }

    @Override
    public boolean isPositiveReview() {
        return rating >= 4;
    }


    public String describe() {
        return getBasicInfo() + ", " + "rating=" + rating + ", " + "comments=" + comments + ", " + "resolved=" + resolved;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "CustomerFeedback";
    }
}