package com.utility.billing;

/**
 * Contract for Billable behavior.
 */
public interface Billable {
    double calculateBill();
    String billSummary();
}