package com.library.system;

import com.library.system.exceptions.BookUnavailableException;
import com.library.system.exceptions.FineCalculationException;
import com.library.system.models.Book;
import com.library.system.models.Librarian;
import com.library.system.models.Member;

/**
 * Main class for Library Management System
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Library Management System ===\n");

            // Create a librarian
            Librarian librarian = new Librarian("LIB001", "Dr. Sharma", 8.5);

            // Create books
            Book book1 = new Book("B001", "Java Programming", "James Gosling", 3);
            Book book2 = new Book("B002", "Data Structures", "Mark Weiss", 2);
            Book book3 = new Book("B003", "Design Patterns", "Gang of Four", 2);

            // Add books to library
            librarian.addBook(book1);
            librarian.addBook(book2);
            librarian.addBook(book3);

            System.out.println("--- Librarian Information ---");
            System.out.println(librarian.getStaffInfo());
            System.out.println("Duty: " + librarian.performDuty());

            // Create members
            System.out.println("\n--- Registering Members ---");
            Member member1 = new Member("M001", "Aman Singh", "aman@email.com");
            Member member2 = new Member("M002", "Bhavna Patel", "bhavna@email.com");
            Member member3 = new Member("M003", "Chirag Kumar", "chirag@email.com");

            librarian.registerMember(member1);
            librarian.registerMember(member2);
            librarian.registerMember(member3);

            System.out.println("✓ Registered member: " + member1.getMemberName());
            System.out.println("✓ Registered member: " + member2.getMemberName());
            System.out.println("✓ Registered member: " + member3.getMemberName());

            // Issue books
            System.out.println("\n--- Issuing Books ---");
            String issue1 = librarian.issueBook("B001", "M001");
            System.out.println("✓ Issued 'Java Programming' to " + member1.getMemberName() + " (Issue: " + issue1 + ")");

            String issue2 = librarian.issueBook("B002", "M002");
            System.out.println("✓ Issued 'Data Structures' to " + member2.getMemberName() + " (Issue: " + issue2 + ")");

            String issue3 = librarian.issueBook("B001", "M003");
            System.out.println("✓ Issued 'Java Programming' to " + member3.getMemberName() + " (Issue: " + issue3 + ")");

            // Display book status
            System.out.println("\n--- Book Availability ---");
            for (Book book : librarian.getManagedBooks()) {
                System.out.println(book);
                System.out.println("  Borrowed: " + book.getBorrowedCopies() + "/" + book.getTotalCopies());
            }

            // Return a book (with fine)
            System.out.println("\n--- Returning Books (Simulating Late Return) ---");
            // Manually update return date to simulate late return
            double fine1 = librarian.returnBook(issue1);
            System.out.println("✓ Book returned by " + member1.getMemberName());
            if (fine1 > 0) {
                System.out.println("  Fine charged: Rs. " + String.format("%.2f", fine1));
                member1.payFine(fine1);
            } else {
                System.out.println("  No fine (returned on time)");
            }

            // Display member details
            System.out.println("\n--- Member Details ---");
            System.out.println(member1);
            System.out.println(member2);
            System.out.println(member3);

            // Test invalid operations
            System.out.println("\n--- Testing Invalid Operations ---");
            testBookUnavailable(librarian);
            testInvalidIssue(librarian);

        } catch (BookUnavailableException | FineCalculationException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testBookUnavailable(Librarian librarian) {
        try {
            System.out.println("Attempting to issue book when all copies are taken...");
            // Try to borrow 4 copies of a book that only has 3 copies
            librarian.issueBook("B003", "M001");
            librarian.issueBook("B003", "M002");
            librarian.issueBook("B003", "M003");
            // This should fail
            Member member4 = new Member("M004", "Dummy", "dummy@email.com");
            librarian.registerMember(member4);
            librarian.issueBook("B003", "M004");
        } catch (BookUnavailableException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidIssue(Librarian librarian) {
        try {
            System.out.println("Attempting to issue non-existent book...");
            librarian.issueBook("B999", "M001");
        } catch (BookUnavailableException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
