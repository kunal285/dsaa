package com.shopping.cart;


/**
 * Concrete entity that stores the project-specific data.
 */
public class CartItem extends ProductRecord implements Discountable {
    private double price;
    private int quantity;
    private double discountRate;


    public CartItem(final String name, final double price, final int quantity, final double discountRate) throws ShoppingException {
        super(name);
        if (price < 0.0) {             throw new ShoppingException("Price cannot be negative.");         }         if (quantity < 1) {             throw new ShoppingException("Quantity must be at least 1.");         }         if (discountRate < 0.0 || discountRate > 100.0) {             throw new ShoppingException("Discount rate must be between 0 and 100.");         }
        this.price = price;
        this.quantity = quantity;
        this.discountRate = discountRate;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) throws ShoppingException {
        if (price < 0.0) {
            throw new ShoppingException("Price cannot be negative.");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) throws ShoppingException {
        if (quantity < 1) {
            throw new ShoppingException("Quantity must be at least 1.");
        }
        this.quantity = quantity;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(final double discountRate) throws ShoppingException {
        if (discountRate < 0.0 || discountRate > 100.0) {
            throw new ShoppingException("Discount rate must be between 0 and 100.");
        }
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscountedTotal() {
        return (price * quantity) - ((price * quantity) * discountRate / 100.0);
    }


    @Override
    public String describe() {
        return getBasicInfo() + ", " + "price=" + price + ", " + "quantity=" + quantity + ", " + "discountRate=" + discountRate;
    }

    @Override
    public String toString() {
        return describe();
    }

    @Override
    public String getCategory() {
        return "CartItem";
    }
}