package com.bank.accounts.interfaces;

import com.bank.accounts.exceptions.InsufficientBalanceException;
import com.bank.accounts.exceptions.InvalidTransactionException;

/**
 * Interface for transactable accounts
 */
public interface Transactable {
    /**
     * Deposit money
     * @param amount amount to deposit
     * @throws InvalidTransactionException if transaction fails
     */
    void deposit(double amount) throws InvalidTransactionException;

    /**
     * Withdraw money
     * @param amount amount to withdraw
     * @throws InsufficientBalanceException if balance is insufficient
     * @throws InvalidTransactionException if transaction is invalid
     */
    void withdraw(double amount) throws InsufficientBalanceException, InvalidTransactionException;

    /**
     * Get current balance
     * @return account balance
     */
    double getBalance();

    /**
     * Get transaction history
     * @return transaction list as string
     */
    String getTransactionHistory();
}
