package com.fooddelivery.app.models;

public final class Restaurant {
    private final String restaurantId;
    private final String restaurantName;
    private final String address;

    public Restaurant(String restaurantId, String restaurantName, String address) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.address = address;
    }

    public String getRestaurantId() { return restaurantId; }
    public String getRestaurantName() { return restaurantName; }
}

class DeliveryPerson {
    private final String deliveryPersonId;
    private final String deliveryPersonName;
    private boolean isAvailable;

    public DeliveryPerson(String deliveryPersonId, String deliveryPersonName) {
        this.deliveryPersonId = deliveryPersonId;
        this.deliveryPersonName = deliveryPersonName;
        this.isAvailable = true;
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public String getDeliveryPersonId() { return deliveryPersonId; }
}
