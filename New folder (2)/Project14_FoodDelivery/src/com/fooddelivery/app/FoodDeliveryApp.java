package com.fooddelivery.app;

import com.fooddelivery.app.models.Order;
import com.fooddelivery.app.models.Restaurant;

public class FoodDeliveryApp {
    public static void main(String[] args) {
        System.out.println("=== Food Delivery App Simulation ===\n");
        Restaurant restaurant = new Restaurant("R001", "Pizza Palace", "123 Main St");
        Order order = new Order(restaurant.getRestaurantId(), 250.0);
        order.updateStatus("CONFIRMED");
        System.out.println("✓ Order " + order.getOrderId() + " placed at " + restaurant.getRestaurantName());
        System.out.println("  Status: " + order.getStatus() + ", Amount: Rs. " + order.getTotalAmount());
    }
}
