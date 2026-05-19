package com.shopping.cart;

/**
 * Represents a checkout order.
 */
public class Order extends ProductRecord {
    private final Product product;
    private final double checkoutTotal;

    public Order(final String name, final Product product) throws ShoppingException {
        super(name);
        if (product == null) {
            throw new ShoppingException("Product cannot be null.");
        }

        this.product = product;
        this.checkoutTotal = product.calculateDiscountedTotal();
    }

    public Product getProduct() {
        return product;
    }

    public double getCheckoutTotal() {
        return checkoutTotal;
    }

    @Override
    public String getCategory() {
        return "Order";
    }

    @Override
    public String describe() {
        return getBasicInfo() + ", product=" + product.getName() + ", checkoutTotal=" + checkoutTotal;
    }

    @Override
    public String toString() {
        return describe();
    }
}