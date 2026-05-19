package com.shopping.cart.models;

import com.shopping.cart.exceptions.CheckoutException;
import com.shopping.cart.exceptions.InvalidQuantityException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cart class representing a shopping cart
 */
public class Cart {
    private final String cartId;
    private final Map<String, CartItem> items;
    private static int cartCounter = 0;

    /**
     * Constructor for Cart
     */
    public Cart() {
        this.cartId = "CART_" + (++cartCounter);
        this.items = new HashMap<>();
    }

    /**
     * Add a product to the cart
     * @param product product to add
     * @param quantity quantity to add
     * @throws InvalidQuantityException if quantity is invalid
     */
    public void addProduct(Product product, int quantity) throws InvalidQuantityException {
        if (items.containsKey(product.getProductId())) {
            CartItem item = items.get(product.getProductId());
            item.updateQuantity(item.getQuantity() + quantity);
        } else {
            items.put(product.getProductId(), new CartItem(product, quantity));
        }
    }

    /**
     * Remove a product from the cart
     * @param productId ID of product to remove
     */
    public void removeProduct(String productId) {
        items.remove(productId);
    }

    /**
     * Update quantity of a product
     * @param productId ID of product
     * @param quantity new quantity
     * @throws InvalidQuantityException if quantity is invalid
     */
    public void updateProductQuantity(String productId, int quantity) throws InvalidQuantityException {
        if (items.containsKey(productId)) {
            items.get(productId).updateQuantity(quantity);
        }
    }

    /**
     * Get total bill amount
     * @return total bill
     */
    public double getTotalBill() {
        return items.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    /**
     * Get number of items in cart
     * @return item count
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Get all items in cart
     * @return list of cart items
     */
    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    /**
     * Clear the cart
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * Checkout and create an order
     * @param customerId customer ID
     * @return Order object
     * @throws CheckoutException if checkout fails
     */
    public Order checkout(String customerId) throws CheckoutException {
        if (items.isEmpty()) {
            throw new CheckoutException("Cannot checkout with empty cart");
        }
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new CheckoutException("Invalid customer ID");
        }

        Order order = new Order(customerId, new ArrayList<>(items.values()), getTotalBill());
        clearCart();
        return order;
    }

    // Getters
    public String getCartId() {
        return cartId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", itemCount=" + items.size() +
                ", totalBill=" + getTotalBill() +
                '}';
    }
}
