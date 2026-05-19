package com.utility.billing.models;

public final class Customer {
    private final String customerId;
    private final String customerName;
    private final String address;

    public Customer(String customerId, String customerName, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
    }

    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
}

class Meter {
    private final String meterId;
    private double currentReading;
    private double previousReading;

    public Meter(String meterId) {
        this.meterId = meterId;
        this.currentReading = 0;
        this.previousReading = 0;
    }

    public void setCurrentReading(double reading) { this.currentReading = reading; }
    public double getUnitsConsumed() { return currentReading - previousReading; }
    public String getMeterId() { return meterId; }
}

class Bill {
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
