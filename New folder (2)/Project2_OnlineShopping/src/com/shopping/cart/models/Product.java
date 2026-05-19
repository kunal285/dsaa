package com.shopping.cart.models;

import com.shopping.cart.exceptions.InvalidPriceException;
import com.shopping.cart.interfaces.Discountable;

/**
 * Product class representing an item in the shopping system
 */
public final class Product implements Discountable {
    private final String productId;
    private final String productName;
    private final double basePrice;
    private double discountPercentage;

    /**
     * Constructor for Product
     * @param productId unique product identifier
     * @param productName name of the product
     * @param basePrice base price of the product
     * @throws InvalidPriceException if price is invalid
     */
    public Product(String productId, String productName, double basePrice) throws InvalidPriceException {
        if (basePrice < 0) {
            throw new InvalidPriceException("Product price cannot be negative: " + basePrice);
        }
        if (productId == null || productId.trim().isEmpty()) {
            throw new InvalidPriceException("Product ID cannot be null or empty");
        }
        this.productId = productId;
        this.productName = productName;
        this.basePrice = basePrice;
        this.discountPercentage = 0.0;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            this.discountPercentage = 0.0;
        } else {
            this.discountPercentage = discountPercentage;
        }
    }

    @Override
    public double getDiscountedPrice() {
        return basePrice - (basePrice * discountPercentage / 100.0);
    }

    @Override
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", basePrice=" + basePrice +
                ", discountPercentage=" + discountPercentage + "%" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return productId.hashCode();
    }
}
