package com.library.system;

/**
 * Contract for Borrowable behavior.
 */
public interface Borrowable {
    boolean borrowBook();
    boolean returnBook();
}