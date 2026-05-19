package com.library.system.models;

import com.library.system.exceptions.BookUnavailableException;
import com.library.system.exceptions.FineCalculationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Librarian class extending LibraryStaff with method overriding
 */
public final class Librarian extends LibraryStaff {
    private final List<Book> managedBooks;
    private final Map<String, Member> registeredMembers;
    private final double yearsOfExperience;

    /**
     * Constructor for Librarian
     * @param staffId unique staff identifier
     * @param staffName staff name
     * @param yearsOfExperience years of experience
     */
    public Librarian(String staffId, String staffName, double yearsOfExperience) {
        super(staffId, staffName, "Librarian", "Library Management");
        this.yearsOfExperience = yearsOfExperience;
        this.managedBooks = new ArrayList<>();
        this.registeredMembers = new HashMap<>();
    }

    /**
     * Add book to library
     * @param book book to add
     */
    public void addBook(Book book) {
        if (!managedBooks.contains(book)) {
            managedBooks.add(book);
        }
    }

    /**
     * Register a member
     * @param member member to register
     */
    public void registerMember(Member member) {
        registeredMembers.put(member.getMemberId(), member);
    }

    /**
     * Issue a book to a member
     * @param bookId book ID
     * @param memberId member ID
     * @return issue ID
     * @throws BookUnavailableException if book is not available
     */
    public String issueBook(String bookId, String memberId) throws BookUnavailableException {
        Book book = findBookById(bookId);
        if (book == null) {
            throw new BookUnavailableException("Book with ID " + bookId + " not found");
        }
        
        String issueId = book.issueBook(memberId);
        Member member = registeredMembers.get(memberId);
        if (member != null) {
            member.borrowBook(bookId, issueId);
        }
        return issueId;
    }

    /**
     * Return a book
     * @param issueId issue ID
     * @return fine amount
     * @throws FineCalculationException if calculation fails
     */
    public double returnBook(String issueId) throws FineCalculationException {
        // Find the book by issue ID
        for (Book book : managedBooks) {
            Map<String, Book.BorrowRecord> records = book.getBorrowRecords();
            if (records.containsKey(issueId)) {
                double fine = book.returnBook(issueId);
                String memberId = records.get(issueId).getMemberId();
                Member member = registeredMembers.get(memberId);
                if (member != null && fine > 0) {
                    // Member should pay the fine
                }
                return fine;
            }
        }
        throw new FineCalculationException("Issue ID " + issueId + " not found");
    }

    /**
     * Find book by ID
     * @param bookId book ID
     * @return book object or null
     */
    private Book findBookById(String bookId) {
        return managedBooks.stream()
                .filter(book -> book.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getStaffInfo() {
        return "Librarian{" +
                "staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", department='" + department + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", managedBooks=" + managedBooks.size() +
                ", registeredMembers=" + registeredMembers.size() +
                '}';
    }

    @Override
    public String performDuty() {
        return staffName + " (Librarian) is managing " + managedBooks.size() + " books " +
               "and " + registeredMembers.size() + " registered members. " +
               "Experience: " + yearsOfExperience + " years.";
    }

    // Getters
    public List<Book> getManagedBooks() {
        return new ArrayList<>(managedBooks);
    }

    public Map<String, Member> getRegisteredMembers() {
        return new HashMap<>(registeredMembers);
    }

    public double getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return getStaffInfo();
    }
}
