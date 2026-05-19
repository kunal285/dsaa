package com.shopping.cart.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Order class representing a completed purchase order
 */
public final class Order {
    private final String orderId;
    private final String customerId;
    private final LocalDateTime orderDate;
    private final List<CartItem> items;
    private final double totalAmount;
    private static int orderCounter = 0;
    private static final String PENDING = "PENDING";
    private static final String SHIPPED = "SHIPPED";
    private static final String DELIVERED = "DELIVERED";
    private String status;

    /**
     * Constructor for Order
     * @param customerId customer ID
     * @param items items in the order
     * @param totalAmount total amount
     */
    public Order(String customerId, List<CartItem> items, double totalAmount) {
        this.orderId = "ORD_" + (++orderCounter);
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.status = PENDING;
    }

    /**
     * Update order status
     * @param newStatus new status
     */
    public void updateStatus(String newStatus) {
        if (newStatus.equals(PENDING) || newStatus.equals(SHIPPED) || newStatus.equals(DELIVERED)) {
            this.status = newStatus;
        }
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderDate=" + orderDate +
                ", itemCount=" + items.size() +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
