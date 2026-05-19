package com.bank.accounts.models;

import java.time.LocalDateTime;

/**
 * Transaction class representing a bank transaction
 */
public final class Transaction {
    private final String transactionId;
    private final String type; // DEPOSIT or WITHDRAWAL
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime timestamp;
    private static int transactionCounter = 0;

    /**
     * Constructor for Transaction
     * @param type transaction type
     * @param amount transaction amount
     * @param balanceAfter balance after transaction
     */
    public Transaction(String type, double amount, double balanceAfter) {
        this.transactionId = "TXN_" + (++transactionCounter);
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return transactionId + " | " + type + " | Rs. " + String.format("%.2f", amount) +
               " | Balance: Rs. " + String.format("%.2f", balanceAfter) + " | " + timestamp;
    }
}
