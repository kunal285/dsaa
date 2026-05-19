package com.shopping.cart;

/**
 * Represents a product that can receive a discount.
 */
public class Product extends ProductRecord implements Discountable {
    private static final double MIN_PRICE = 0.0;

    private final double price;
    private final int quantity;
    private final double discountRate;

    public Product(final String name, final double price, final int quantity, final double discountRate) throws ShoppingException {
        super(name);
        validateValues(price, quantity, discountRate);
        this.price = price;
        this.quantity = quantity;
        this.discountRate = discountRate;
    }

    private void validateValues(final double price, final int quantity, final double discountRate) throws ShoppingException {
        if (price < MIN_PRICE) {
            throw new ShoppingException("Price cannot be negative.");
        }
        if (quantity < 1) {
            throw new ShoppingException("Quantity must be at least 1.");
        }
        if (discountRate < 0.0 || discountRate > 100.0) {
            throw new ShoppingException("Discount rate must be between 0 and 100.");
        }
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public double calculateDiscountedTotal() {
        return (price * quantity) - ((price * quantity) * discountRate / 100.0);
    }

    @Override
    public String getCategory() {
        return "Product";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", price=" + price + ", quantity=" + quantity + ", discountRate=" + discountRate;
    }

    @Override
    public String toString() {
        return describe();
    }
}