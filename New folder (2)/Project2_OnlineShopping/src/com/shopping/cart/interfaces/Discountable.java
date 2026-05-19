package com.shopping.cart.interfaces;

/**
 * Interface for discountable items
 */
public interface Discountable {
    /**
     * Apply discount to the item
     * @param discountPercentage discount percentage (0-100)
     */
    void applyDiscount(double discountPercentage);

    /**
     * Get discounted price
     * @return discounted price
     */
    double getDiscountedPrice();

    /**
     * Get discount percentage
     * @return discount percentage
     */
    double getDiscountPercentage();
}
