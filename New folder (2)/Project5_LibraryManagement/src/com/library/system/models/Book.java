package com.library.system.models;

import com.library.system.exceptions.BookUnavailableException;
import com.library.system.exceptions.FineCalculationException;
import com.library.system.interfaces.Borrowable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Book class implementing borrowable interface
 */
public class Book implements Borrowable {
    private final String bookId;
    private final String bookTitle;
    private final String author;
    private final int totalCopies;
    private int availableCopies;
    private final int maxBorrowDays;
    private final double finePerDay;
    private static final double DAILY_FINE = 10.0;
    private static final int MAX_BORROW_DAYS = 14;
    private static int issueCounter = 0;
    private final Map<String, BorrowRecord> borrowRecords;

    /**
     * Constructor for Book
     * @param bookId unique book identifier
     * @param bookTitle title of the book
     * @param author author name
     * @param totalCopies total copies available
     */
    public Book(String bookId, String bookTitle, String author, int totalCopies) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.maxBorrowDays = MAX_BORROW_DAYS;
        this.finePerDay = DAILY_FINE;
        this.borrowRecords = new HashMap<>();
    }

    @Override
    public String issueBook(String memberId) throws BookUnavailableException {
        if (availableCopies <= 0) {
            throw new BookUnavailableException("Book '" + bookTitle + "' is not available. No copies left.");
        }
        
        availableCopies--;
        String issueId = "ISSUE_" + (++issueCounter);
        borrowRecords.put(issueId, new BorrowRecord(issueId, memberId, bookId, LocalDate.now(), maxBorrowDays));
        return issueId;
    }

    @Override
    public double returnBook(String issueId) throws FineCalculationException {
        if (!borrowRecords.containsKey(issueId)) {
            throw new FineCalculationException("Invalid issue ID: " + issueId);
        }
        
        BorrowRecord record = borrowRecords.get(issueId);
        if (record.getReturnDate() != null) {
            throw new FineCalculationException("Book already returned for issue ID: " + issueId);
        }
        
        record.setReturnDate(LocalDate.now());
        availableCopies++;
        
        // Calculate fine
        long daysLate = ChronoUnit.DAYS.between(record.getDueDate(), LocalDate.now());
        if (daysLate <= 0) {
            return 0.0;
        }
        
        return daysLate * finePerDay;
    }

    @Override
    public boolean isAvailable() {
        return availableCopies > 0;
    }

    @Override
    public int getAvailableCopies() {
        return availableCopies;
    }

    // Getters
    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getBorrowedCopies() {
        return totalCopies - availableCopies;
    }

    public Map<String, BorrowRecord> getBorrowRecords() {
        return new HashMap<>(borrowRecords);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }

    /**
     * Inner class for borrow records
     */
    public static class BorrowRecord {
        private final String issueId;
        private final String memberId;
        private final String bookId;
        private final LocalDate issueDate;
        private final LocalDate dueDate;
        private LocalDate returnDate;

        public BorrowRecord(String issueId, String memberId, String bookId, LocalDate issueDate, int borrowDays) {
            this.issueId = issueId;
            this.memberId = memberId;
            this.bookId = bookId;
            this.issueDate = issueDate;
            this.dueDate = issueDate.plusDays(borrowDays);
            this.returnDate = null;
        }

        public String getIssueId() { return issueId; }
        public String getMemberId() { return memberId; }
        public String getBookId() { return bookId; }
        public LocalDate getIssueDate() { return issueDate; }
        public LocalDate getDueDate() { return dueDate; }
        public LocalDate getReturnDate() { return returnDate; }
        public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

        public boolean isLate() {
            return returnDate != null && returnDate.isAfter(dueDate);
        }

        @Override
        public String toString() {
            return "BorrowRecord{" +
                    "issueId='" + issueId + '\'' +
                    ", memberId='" + memberId + '\'' +
                    ", issueDate=" + issueDate +
                    ", dueDate=" + dueDate +
                    ", returnDate=" + returnDate +
                    '}';
        }
    }
}
