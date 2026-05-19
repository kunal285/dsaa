package com.fooddelivery.app.models;

import java.time.LocalDateTime;

public final class Order {
    private final String orderId;
    private final String restaurantId;
    private final double totalAmount;
    private final LocalDateTime orderTime;
    private static int orderCounter = 0;
    private String status;

    public Order(String restaurantId, double totalAmount) {
        this.orderId = "ORD_" + (++orderCounter);
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.orderTime = LocalDateTime.now();
        this.status = "PLACED";
    }

    public void updateStatus(String status) { this.status = status; }
    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public double getTotalAmount() { return totalAmount; }
}
