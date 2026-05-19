package com.utility.billing;

import com.utility.billing.models.Bill;
import com.utility.billing.models.Customer;
import com.utility.billing.models.Meter;

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        System.out.println("=== Electricity Bill Generator ===\n");
        Customer customer = new Customer("C001", "Rajesh Kumar", "Mumbai");
        Meter meter = new Meter("M001");
        meter.setCurrentReading(250);
        double units = meter.getUnitsConsumed();
        double amount = units * 8.5; // Rs. 8.5 per unit
        Bill bill = new Bill("B001", amount);
        System.out.println("✓ Bill for " + customer.getCustomerName());
        System.out.println("  Units: " + units);
        System.out.println("  Amount: Rs. " + String.format("%.2f", bill.getAmount()));
        System.out.println("  Status: " + bill.getStatus());
    }
}
