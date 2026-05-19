package com.bank.accounts;

import com.bank.accounts.exceptions.InsufficientBalanceException;
import com.bank.accounts.exceptions.InvalidTransactionException;
import com.bank.accounts.models.SavingsAccount;
import com.bank.accounts.models.Transaction;

/**
 * Main class for Banking System with Transaction History
 */
public class BankingSystem {
    public static void main(String[] args) throws InsufficientBalanceException {
        try {
            System.out.println("=== Banking System with Transaction History ===\n");

            // Create accounts
            SavingsAccount account1 = new SavingsAccount("ACC001", "Rahul Sharma", 50000.0);
            SavingsAccount account2 = new SavingsAccount("ACC002", "Neha Verma", 30000.0, 0.05, 10000.0);

            System.out.println("--- Account Information ---");
            System.out.println(account1);
            System.out.println(account2);

            // Perform transactions
            System.out.println("\n--- Performing Transactions ---");
            
            // Account 1 transactions
            account1.deposit(20000);
            System.out.println("✓ Deposited Rs. 20,000 to " + account1.getAccountHolderName());

            account1.withdraw(10000);
            System.out.println("✓ Withdrew Rs. 10,000 from " + account1.getAccountHolderName());

            account1.deposit(5000);
            System.out.println("✓ Deposited Rs. 5,000 to " + account1.getAccountHolderName());

            // Account 2 transactions
            account2.withdraw(8000);
            System.out.println("✓ Withdrew Rs. 8,000 from " + account2.getAccountHolderName());

            account2.deposit(15000);
            System.out.println("✓ Deposited Rs. 15,000 to " + account2.getAccountHolderName());

            account2.withdraw(20000);
            System.out.println("✓ Withdrew Rs. 20,000 from " + account2.getAccountHolderName());

            // Display balances
            System.out.println("\n--- Current Balances ---");
            System.out.println(account1.getAccountHolderName() + " Balance: Rs. " + 
                             String.format("%.2f", account1.getBalance()));
            System.out.println(account2.getAccountHolderName() + " Balance: Rs. " +
                             String.format("%.2f", account2.getBalance()));

            // Add interest
            System.out.println("\n--- Adding Monthly Interest ---");
            System.out.println("Minimum Balance Maintained for Account1: " + account1.isMaintainingMinimumBalance());
            account1.addInterest();
            System.out.println("✓ Added interest to Account1. New Balance: Rs. " + 
                             String.format("%.2f", account1.getBalance()));

            System.out.println("Minimum Balance Maintained for Account2: " + account2.isMaintainingMinimumBalance());
            if (account2.isMaintainingMinimumBalance()) {
                account2.addInterest();
                System.out.println("✓ Added interest to Account2. New Balance: Rs. " +
                                 String.format("%.2f", account2.getBalance()));
            } else {
                System.out.println("✗ Interest not added to Account2 (Minimum balance not maintained)");
            }

            // Display transaction history
            System.out.println("\n--- Transaction History ---");
            System.out.println(account1.getTransactionHistory());
            System.out.println();
            System.out.println(account2.getTransactionHistory());

            // Get last 3 transactions
            System.out.println("\n--- Last 3 Transactions for Account1 ---");
            for (Transaction txn : account1.getLastTransactions(3)) {
                System.out.println(txn);
            }

            // Test invalid operations
            System.out.println("\n--- Testing Invalid Operations ---");
            testInsufficientBalance(account1);
            testInvalidDeposit(account1);
            testInvalidWithdrawal(account1);

        } catch (InvalidTransactionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testInsufficientBalance(SavingsAccount account) {
        try {
            System.out.println("Attempting to withdraw more than available balance...");
            account.withdraw(1000000);
        } catch (InsufficientBalanceException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        } catch (InvalidTransactionException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void testInvalidDeposit(SavingsAccount account) {
        try {
            System.out.println("Attempting to deposit negative amount...");
            account.deposit(-5000);
        } catch (InvalidTransactionException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInvalidWithdrawal(SavingsAccount account) {
        try {
            System.out.println("Attempting to withdraw zero amount...");
            account.withdraw(0);
        } catch (InsufficientBalanceException | InvalidTransactionException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
