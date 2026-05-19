package com.library.system;

/**
 * Library member who can issue books.
 */
public class Member extends LibraryItemRecord {
    private final String membershipId;

    public Member(final String name, final String membershipId) throws LibraryException {
        super(name);
        if (membershipId == null || membershipId.trim().isEmpty()) {
            throw new LibraryException("Membership id cannot be blank.");
        }

        this.membershipId = membershipId.trim();
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String issueBook(final Book book) throws BookUnavailableException {
        if (book == null) {
            throw new BookUnavailableException("Book cannot be null.");
        }
        if (!book.borrowBook()) {
            throw new BookUnavailableException("Book is already issued.");
        }

        return getName() + " issued " + book.getName();
    }

    public String returnBook(final Book book, final int daysLate) throws LibraryException {
        if (book == null) {
            throw new LibraryException("Book cannot be null.");
        }
        book.returnBook();
        return getName() + " returned " + book.getName() + ", fine=" + book.calculateFine(daysLate);
    }

    @Override
    public String getCategory() {
        return "Member";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", membershipId=" + membershipId;
    }

    @Override
    public String toString() {
        return describe();
    }
}