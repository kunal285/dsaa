package com.bank.accounts;
import java.util.ArrayList;


/**
 * Concrete entity that stores the project-specific data.
 */
public class BankAccount extends AccountRecord implements Transactable {
    private double balance;
    private String accountHolder;
    private final ArrayList<String> transactionHistory = new ArrayList<>();


    public BankAccount(final String name, final double balance, final String accountHolder) throws BankingException {
        super(name);
        if (balance < 0.0) {             throw new BankingException("Balance cannot be negative.");         }         if (accountHolder == null || accountHolder.trim().isEmpty()) {             throw new BankingException("Account holder cannot be blank.");         }
        this.balance = balance;
        this.accountHolder = accountHolder;
        transactionHistory.add("Account opened with balance " + balance);

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) throws BankingException {
        if (balance < 0.0) {
            throw new BankingException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(final String accountHolder) throws BankingException {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new BankingException("Account holder cannot be blank.");
        }
        this.accountHolder = accountHolder;
    }

    @Override
    public void deposit(final double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactionHistory.add("Deposit: " + amount);
    }

    @Override
    public void withdraw(final double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
        transactionHistory.add("Withdraw: " + amount);
    }

    @Override
    public String transactionHistory() {
        return String.join(" | ", transactionHistory) + "; current balance=" + balance;
    }


    public String describe() {
        return getBasicInfo() + ", " + "balance=" + balance + ", " + "accountHolder=" + accountHolder;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "BankAccount";
    }
}