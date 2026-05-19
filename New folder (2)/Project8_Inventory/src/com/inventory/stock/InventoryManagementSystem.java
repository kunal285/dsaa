package com.inventory.stock;

import com.inventory.stock.exceptions.StockException;
import com.inventory.stock.models.Item;
import com.inventory.stock.models.Warehouse;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        try {
            System.out.println("=== Inventory Management System ===\n");

            Warehouse warehouse = new Warehouse("WH001", "Mumbai");
            System.out.println("--- Warehouse Info ---");
            System.out.println(warehouse);

            Item item1 = new Item("I001", "Laptop", 50000.0, 15, 5);
            Item item2 = new Item("I002", "Mouse", 500.0, 8, 10);
            Item item3 = new Item("I003", "Keyboard", 2000.0, 20, 5);

            warehouse.addItem(item1);
            warehouse.addItem(item2);
            warehouse.addItem(item3);

            System.out.println("\n--- Inventory Items ---");
            System.out.println(item1);
            System.out.println(item2);
            System.out.println(item3);

            System.out.println("\n--- Stock Operations ---");
            item1.removeStock(5);
            System.out.println("✓ Sold 5 Laptops. Remaining: " + item1.getStock());

            item2.removeStock(3);
            System.out.println("✓ Sold 3 Mouse. Remaining: " + item2.getStock());

            System.out.println("\n--- Low Stock Alert ---");
            for (Item item : warehouse.getLowStockItems()) {
                System.out.println("⚠ ALERT: " + item.getItemName() + " stock is low (" + item.getStock() + ")");
            }

            System.out.println("\n--- Restocking ---");
            item2.addStock(15);
            System.out.println("✓ Restocked " + item2.getItemName() + ". New quantity: " + item2.getStock());

            System.out.println("\n--- Testing Invalid Operations ---");
            testNegativeQuantity(item1);
            testInsufficientStock(item1);

        } catch (StockException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testNegativeQuantity(Item item) {
        try {
            System.out.println("Attempting to add negative quantity...");
            item.addStock(-5);
        } catch (StockException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }

    private static void testInsufficientStock(Item item) {
        try {
            System.out.println("Attempting to remove more than available stock...");
            item.removeStock(1000);
        } catch (StockException e) {
            System.out.println("✓ Caught: " + e.getMessage());
        }
    }
}
