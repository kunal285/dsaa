package com.shopping.cart;

import com.shopping.cart.exceptions.CheckoutException;
import com.shopping.cart.exceptions.InvalidPriceException;
import com.shopping.cart.exceptions.InvalidQuantityException;
import com.shopping.cart.models.Cart;
import com.shopping.cart.models.CartItem;
import com.shopping.cart.models.Order;
import com.shopping.cart.models.Product;

/**
 * Main class for Online Shopping System
 */
public class OnlineShoppingSystem {

    public static void main(String[] args) {

        System.out.println("=== Online Shopping System ===\n");

        try {

            // Create products
            Product laptop = new Product("P001", "Laptop", 75000.0);
            Product mouse = new Product("P002", "Wireless Mouse", 1500.0);
            Product keyboard = new Product("P003", "Mechanical Keyboard", 5000.0);
            Product monitor = new Product("P004", "4K Monitor", 35000.0);

            // Display products
            System.out.println("--- Available Products ---");
            System.out.println(laptop);
            System.out.println(mouse);
            System.out.println(keyboard);
            System.out.println(monitor);

            // Create cart
            Cart cart = new Cart();

            // Add products
            System.out.println("\n--- Adding Products to Cart ---");

            cart.addProduct(laptop, 1);
            System.out.println("✓ Added 1 Laptop");

            cart.addProduct(mouse, 2);
            System.out.println("✓ Added 2 Wireless Mouse");

            cart.addProduct(keyboard, 1);
            System.out.println("✓ Added 1 Mechanical Keyboard");

            // Apply discounts
            System.out.println("\n--- Applying Discounts ---");

            laptop.applyDiscount(10);
            System.out.println("✓ Applied 10% discount on Laptop");

            mouse.applyDiscount(5);
            System.out.println("✓ Applied 5% discount on Wireless Mouse");

            keyboard.applyDiscount(15);
            System.out.println("✓ Applied 15% discount on Mechanical Keyboard");

            // Display cart
            System.out.println("\n--- Cart Contents ---");
            System.out.println(cart);

            System.out.println("\nItems:");
            for (CartItem item : cart.getItems()) {
                System.out.println(item);
            }

            System.out.println("\nTotal Bill: Rs. "
                    + String.format("%.2f", cart.getTotalBill()));

            // Update quantity
            System.out.println("\n--- Updating Quantity ---");

            cart.updateProductQuantity("P002", 3);

            System.out.println("✓ Updated Mouse quantity to 3");

            System.out.println("Updated Total Bill: Rs. "
                    + String.format("%.2f", cart.getTotalBill()));

            // Checkout
            System.out.println("\n--- Checkout Process ---");

            Order order = cart.checkout("CUST001");

            System.out.println("✓ Order placed successfully!");
            System.out.println(order);

            // Testing invalid operations
            System.out.println("\n--- Testing Invalid Operations ---");

            testInvalidPrice();
            testInvalidQuantity();
            testEmptyCartCheckout();

        } catch (InvalidPriceException e) {

            System.err.println("Invalid Price Error: " + e.getMessage());

        } catch (InvalidQuantityException e) {

            System.err.println("Invalid Quantity Error: " + e.getMessage());

        } catch (CheckoutException e) {

            System.err.println("Checkout Error: " + e.getMessage());

        } catch (Exception e) {

            System.err.println("Unexpected Error: " + e.getMessage());
        }
    }

    /**
     * Test invalid price
     */
    @SuppressWarnings("unused")
    private static void testInvalidPrice() {

        try {

            System.out.println("\nAttempting to create product with negative price...");
            Product invalidProduct = new Product("P099", "Invalid Product", -1000.0);
            // If we reach here, the exception wasn't thrown (test fails)
            System.out.println("✗ Test Failed: Exception not thrown");

        } catch (InvalidPriceException e) {
            System.out.println("✓ Caught Exception: " + e.getMessage());
        }
    }

    /**
     * Test invalid quantity
     */
    private static void testInvalidQuantity() {

        try {

            System.out.println("\nAttempting to add product with negative quantity...");
            Cart cart = new Cart();

            Product product = new Product("P099", "Test Product", 100.0);

            cart.addProduct(product, -5);

        } catch (InvalidPriceException | InvalidQuantityException e) {

            System.out.println("✓ Caught Exception: " + e.getMessage());
        }
    }

    /**
     * Test empty cart checkout
     */
    private static void testEmptyCartCheckout() {

        try {

            System.out.println("\nAttempting to checkout with empty cart...");
            Cart cart = new Cart();

            cart.checkout("CUST999");

        } catch (CheckoutException e) {

            System.out.println("✓ Caught Exception: " + e.getMessage());
        }
    }
}