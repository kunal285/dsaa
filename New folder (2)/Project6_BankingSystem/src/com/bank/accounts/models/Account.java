package com.bank.accounts.models;

import com.bank.accounts.exceptions.InsufficientBalanceException;
import com.bank.accounts.exceptions.InvalidTransactionException;
import com.bank.accounts.interfaces.Transactable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Account class representing a bank account
 */
public abstract class Account implements Transactable {
    protected final String accountNumber;
    protected final String accountHolderName;
    protected double balance;
    protected final List<Transaction> transactionHistory;

    /**
     * Constructor for Account
     * @param accountNumber unique account number
     * @param accountHolderName name of account holder
     * @param initialBalance initial account balance
     * @throws InvalidTransactionException if initial balance is invalid
     */
    public Account(String accountNumber, String accountHolderName, double initialBalance) 
            throws InvalidTransactionException {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new InvalidTransactionException("Account number cannot be null or empty");
        }
        if (initialBalance < 0) {
            throw new InvalidTransactionException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit amount must be positive, received: " + amount);
        }
        
        this.balance += amount;
        Transaction txn = new Transaction("DEPOSIT", amount, this.balance);
        transactionHistory.add(txn);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be positive, received: " + amount);
        }
        if (amount > this.balance) {
            throw new InsufficientBalanceException("Insufficient balance. Available: Rs. " + this.balance +
                                                  ", Requested: Rs. " + amount);
        }
        
        this.balance -= amount;
        Transaction txn = new Transaction("WITHDRAWAL", amount, this.balance);
        transactionHistory.add(txn);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            return "No transactions yet";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction History for Account: ").append(accountNumber).append("\n");
        sb.append("=".repeat(80)).append("\n");
        for (Transaction txn : transactionHistory) {
            sb.append(txn).append("\n");
        }
        return sb.toString();
    }

    /**
     * Get last N transactions
     * @param count number of transactions
     * @return list of transactions
     */
    public List<Transaction> getLastTransactions(int count) {
        int startIndex = Math.max(0, transactionHistory.size() - count);
        return new ArrayList<>(transactionHistory.subList(startIndex, transactionHistory.size()));
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactionHistory);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", transactionCount=" + transactionHistory.size() +
                '}';
    }
}
