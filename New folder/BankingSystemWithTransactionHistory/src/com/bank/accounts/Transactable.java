package com.bank.accounts;

/**
 * Contract for Transactable behavior.
 */
public interface Transactable {
    void deposit(final double amount);
    void withdraw(final double amount);
    String transactionHistory();
}