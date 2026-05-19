package com.bank.accounts.models;

import com.bank.accounts.exceptions.InvalidTransactionException;

/**
 * SavingsAccount class extending Account with interest features
 */
public final class SavingsAccount extends Account {
    private final double interestRate;
    private final double minimumBalance;
    private static final double DEFAULT_INTEREST_RATE = 0.04; // 4% per annum
    private static final double DEFAULT_MINIMUM_BALANCE = 5000.0;

    /**
     * Constructor for SavingsAccount with default settings
     * @param accountNumber unique account number
     * @param accountHolderName name of account holder
     * @param initialBalance initial account balance
     * @throws InvalidTransactionException if initial balance is invalid
     */
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance)
            throws InvalidTransactionException {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = DEFAULT_INTEREST_RATE;
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    /**
     * Constructor for SavingsAccount with custom settings
     * @param accountNumber unique account number
     * @param accountHolderName name of account holder
     * @param initialBalance initial account balance
     * @param interestRate custom interest rate
     * @param minimumBalance custom minimum balance
     * @throws InvalidTransactionException if initial balance is invalid
     */
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance,
                         double interestRate, double minimumBalance)
            throws InvalidTransactionException {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    /**
     * Calculate and add interest to account
     */
    public void addInterest() {
        if (balance >= minimumBalance) {
            double interest = balance * interestRate / 12; // Monthly interest
            try {
                this.balance += interest;
                Transaction txn = new Transaction("INTEREST_CREDIT", interest, this.balance);
                transactionHistory.add(txn);
            } catch (Exception e) {
                // Should not happen in normal flow
            }
        }
    }

    /**
     * Check if minimum balance is maintained
     * @return true if balance >= minimum balance
     */
    public boolean isMaintainingMinimumBalance() {
        return balance >= minimumBalance;
    }

    // Getters
    public double getInterestRate() {
        return interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", interestRate=" + (interestRate * 100) + "%" +
                ", minimumBalance=" + minimumBalance +
                ", transactionCount=" + transactionHistory.size() +
                '}';
    }
}
