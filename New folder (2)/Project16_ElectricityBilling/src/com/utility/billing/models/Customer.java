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

