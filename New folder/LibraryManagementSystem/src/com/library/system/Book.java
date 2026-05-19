package com.library.system;

/**
 * Represents a library book.
 */
public class Book extends LibraryItemRecord implements Borrowable {
    private static final double DEFAULT_FINE_PER_DAY = 2.0;

    private final String author;
    private final double finePerDay;
    private int borrowedDays;
    private boolean borrowed;

    public Book(final String title, final String author, final int borrowedDays, final boolean borrowed) throws LibraryException {
        super(title);
        if (author == null || author.trim().isEmpty()) {
            throw new LibraryException("Author cannot be blank.");
        }
        if (borrowedDays < 0) {
            throw new LibraryException("Borrowed days cannot be negative.");
        }

        this.author = author.trim();
        this.borrowedDays = borrowedDays;
        this.borrowed = borrowed;
        this.finePerDay = DEFAULT_FINE_PER_DAY;
    }

    public String getAuthor() {
        return author;
    }

    public int getBorrowedDays() {
        return borrowedDays;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public double calculateFine(final int daysLate) throws FineCalculationException {
        if (daysLate < 0) {
            throw new FineCalculationException("Days late cannot be negative.");
        }

        return daysLate * finePerDay;
    }

    public void setBorrowedDays(final int borrowedDays) throws LibraryException {
        if (borrowedDays < 0) {
            throw new LibraryException("Borrowed days cannot be negative.");
        }

        this.borrowedDays = borrowedDays;
    }

    @Override
    public boolean borrowBook() {
        if (borrowed) {
            return false;
        }

        borrowed = true;
        return true;
    }

    @Override
    public boolean returnBook() {
        if (!borrowed) {
            return false;
        }

        borrowed = false;
        return true;
    }

    @Override
    public String getCategory() {
        return "Book";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", author=" + author + ", borrowedDays=" + borrowedDays + ", borrowed=" + borrowed;
    }

    @Override
    public String toString() {
        return describe();
    }
}