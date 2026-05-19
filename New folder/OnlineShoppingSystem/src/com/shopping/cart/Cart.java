package com.shopping.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Shopping cart that stores products in a collection.
 */
public class Cart {
    private static final int MAX_ITEMS = 1000;

    private final ArrayList<Product> products = new ArrayList<>();

    public void addProduct(final Product product) throws ShoppingException {
        if (product == null) {
            throw new ShoppingException("Product cannot be null.");
        }
        if (products.size() >= MAX_ITEMS) {
            throw new ShoppingException("Maximum capacity reached.");
        }

        products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public double calculateCartTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.calculateDiscountedTotal();
        }
        return total;
    }

    public Product findByName(final String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void printAll() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }
}