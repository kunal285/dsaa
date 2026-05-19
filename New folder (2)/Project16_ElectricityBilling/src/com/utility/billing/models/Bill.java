package com.utility.billing.models;

public class Bill {
    private final String billId;
    private final double amount;
    private String status;

    public Bill(String billId, double amount) {
        this.billId = billId;
        this.amount = amount;
        this.status = "PENDING";
    }

    public void pay() { this.status = "PAID"; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}
