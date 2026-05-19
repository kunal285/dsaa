package com.library.system;


/**
 * Concrete entity that stores the project-specific data.
 */
public class BookItem extends LibraryItemRecord implements Borrowable {
    private String author;
    private int borrowedDays;
    private boolean borrowed;


    public BookItem(final String name, final String author, final int borrowedDays, final boolean borrowed) throws LibraryException {
        super(name);
        if (author == null || author.trim().isEmpty()) {             throw new LibraryException("Author cannot be blank.");         }         if (borrowedDays < 0) {             throw new LibraryException("Borrowed days cannot be negative.");         }
        this.author = author;
        this.borrowedDays = borrowedDays;
        this.borrowed = borrowed;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) throws LibraryException {
        if (author == null || author.trim().isEmpty()) {
            throw new LibraryException("Author cannot be blank.");
        }
        this.author = author;
    }

    public int getBorrowedDays() {
        return borrowedDays;
    }

    public void setBorrowedDays(final int borrowedDays) throws LibraryException {
        if (borrowedDays < 0) {
            throw new LibraryException("Borrowed days cannot be negative.");
        }
        this.borrowedDays = borrowedDays;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(final boolean borrowed) throws LibraryException {
        this.borrowed = borrowed;
    }

    @Override
    public boolean borrowBook() {
        if (borrowed) { return false; } borrowed = true; return true;
    }

    @Override
    public boolean returnBook() {
        if (!borrowed) { return false; } borrowed = false; return true;
    }


    @Override
    public String describe() {
        return getBasicInfo() + ", " + "author=" + author + ", " + "borrowedDays=" + borrowedDays + ", " + "borrowed=" + borrowed;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "BookItem";
    }
}