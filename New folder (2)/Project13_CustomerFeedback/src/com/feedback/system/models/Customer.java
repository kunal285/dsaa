package com.feedback.system.models;

public final class Customer {
    private final String customerId;
    private final String customerName;
    private final String email;

    public Customer(String customerId, String customerName, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
    }

    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getEmail() { return email; }
}
