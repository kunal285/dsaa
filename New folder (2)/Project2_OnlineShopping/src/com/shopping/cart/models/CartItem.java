package com.shopping.cart.models;

import com.shopping.cart.exceptions.InvalidQuantityException;

/**
 * CartItem class representing a product with quantity in the shopping cart
 */
public final class CartItem {
    private final Product product;
    private int quantity;

    /**
     * Constructor for CartItem
     * @param product the product
     * @param quantity quantity of the product
     * @throws InvalidQuantityException if quantity is invalid
     */
    public CartItem(Product product, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0, received: " + quantity);
        }
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Update quantity
     * @param quantity new quantity
     * @throws InvalidQuantityException if quantity is invalid
     */
    public void updateQuantity(int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0, received: " + quantity);
        }
        this.quantity = quantity;
    }

    /**
     * Get total price for this item
     * @return total price
     */
    public double getTotalPrice() {
        return product.getDiscountedPrice() * quantity;
    }

    // Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product.getProductName() +
                ", quantity=" + quantity +
                ", unitPrice=" + product.getDiscountedPrice() +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
