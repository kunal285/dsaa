package com.library.system.interfaces;

import com.library.system.exceptions.BookUnavailableException;
import com.library.system.exceptions.FineCalculationException;

/**
 * Interface for borrowable items
 */
public interface Borrowable {
    /**
     * Issue a book to a member
     * @param memberId member ID
     * @return issue ID
     * @throws BookUnavailableException if book is not available
     */
    String issueBook(String memberId) throws BookUnavailableException;

    /**
     * Return a borrowed book
     * @param issueId issue ID
     * @return fine amount
     * @throws FineCalculationException if fine calculation fails
     */
    double returnBook(String issueId) throws FineCalculationException;

    /**
     * Check if book is available
     * @return true if available
     */
    boolean isAvailable();

    /**
     * Get available copies
     * @return number of available copies
     */
    int getAvailableCopies();
}
