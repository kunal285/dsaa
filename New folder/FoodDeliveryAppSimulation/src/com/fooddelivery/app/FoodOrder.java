package com.fooddelivery.app;


/**
 * Concrete entity that stores the project-specific data.
 */
public class FoodOrder extends OrderRecord implements Deliverable {
    private String restaurantName;
    private double orderTotal;
    private boolean delivered;


    public FoodOrder(final String name, final String restaurantName, final double orderTotal, final boolean delivered) throws FoodDeliveryException {
        super(name);
        if (restaurantName == null || restaurantName.trim().isEmpty()) {             throw new FoodDeliveryException("Restaurant name cannot be blank.");         }         if (orderTotal < 0.0) {             throw new FoodDeliveryException("Order total cannot be negative.");         }
        this.restaurantName = restaurantName;
        this.orderTotal = orderTotal;
        this.delivered = delivered;

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(final String restaurantName) throws FoodDeliveryException {
        if (restaurantName == null || restaurantName.trim().isEmpty()) {
            throw new FoodDeliveryException("Restaurant name cannot be blank.");
        }
        this.restaurantName = restaurantName;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(final double orderTotal) throws FoodDeliveryException {
        if (orderTotal < 0.0) {
            throw new FoodDeliveryException("Order total cannot be negative.");
        }
        this.orderTotal = orderTotal;
    }

    public boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(final boolean delivered) throws FoodDeliveryException {
        this.delivered = delivered;
    }

    @Override
    public double deliveryCharge() {
        return orderTotal * 0.10 + 25.0;
    }

    @Override
    public String deliverOrder() {
        delivered = true; return "Order delivered from " + restaurantName;
    }


    public String describe() {
        return getBasicInfo() + ", " + "restaurantName=" + restaurantName + ", " + "orderTotal=" + orderTotal + ", " + "delivered=" + delivered;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "FoodOrder";
    }
}