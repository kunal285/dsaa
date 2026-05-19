package com.library.system;

/**
 * Librarian extends member and can manage book operations.
 */
public class Librarian extends Member {
    private final String employeeCode;

    public Librarian(final String name, final String membershipId, final String employeeCode) throws LibraryException {
        super(name, membershipId);
        if (employeeCode == null || employeeCode.trim().isEmpty()) {
            throw new LibraryException("Employee code cannot be blank.");
        }

        this.employeeCode = employeeCode.trim();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    @Override
    public String issueBook(final Book book) throws BookUnavailableException {
        return "Librarian processed: " + super.issueBook(book);
    }

    @Override
    public String returnBook(final Book book, final int daysLate) throws LibraryException {
        return "Librarian processed: " + super.returnBook(book, daysLate);
    }

    @Override
    public String getCategory() {
        return "Librarian";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", membershipId=" + getMembershipId() + ", employeeCode=" + employeeCode;
    }
}