package com.library.system.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Member class representing a library member
 */
public class Member {
    private final String memberId;
    private final String memberName;
    private final String email;
    private final LocalDate membershipDate;
    private final List<String> borrowedBookIds;
    private final List<String> issueIds;
    private double totalFinesPaid;

    /**
     * Constructor for Member
     * @param memberId unique member identifier
     * @param memberName member name
     * @param email member email
     */
    public Member(String memberId, String memberName, String email) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.email = email;
        this.membershipDate = LocalDate.now();
        this.borrowedBookIds = new ArrayList<>();
        this.issueIds = new ArrayList<>();
        this.totalFinesPaid = 0.0;
    }

    /**
     * Add borrowed book
     * @param bookId book ID
     * @param issueId issue ID
     */
    public void borrowBook(String bookId, String issueId) {
        this.borrowedBookIds.add(bookId);
        this.issueIds.add(issueId);
    }

    /**
     * Remove returned book
     * @param issueId issue ID
     */
    public void returnBook(String issueId) {
        this.issueIds.remove(issueId);
    }

    /**
     * Pay fine
     * @param fineAmount amount to pay
     */
    public void payFine(double fineAmount) {
        this.totalFinesPaid += fineAmount;
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public List<String> getBorrowedBookIds() {
        return new ArrayList<>(borrowedBookIds);
    }

    public List<String> getIssueIds() {
        return new ArrayList<>(issueIds);
    }

    public double getTotalFinesPaid() {
        return totalFinesPaid;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", membershipDate=" + membershipDate +
                ", activeBorrowals=" + issueIds.size() +
                ", totalFinesPaid=" + totalFinesPaid +
                '}';
    }
}
