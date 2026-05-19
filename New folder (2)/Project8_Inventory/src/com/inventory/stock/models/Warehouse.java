package com.inventory.stock.models;

import com.inventory.stock.exceptions.StockException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Warehouse {
    private final String warehouseId;
    private final String location;
    private final Map<String, Item> items;

    public Warehouse(String warehouseId, String location) throws StockException {
        if (warehouseId == null || warehouseId.isEmpty()) {
            throw new StockException("Warehouse ID cannot be empty");
        }
        this.warehouseId = warehouseId;
        this.location = location;
        this.items = new HashMap<>();
    }

    public void addItem(Item item) throws StockException {
        if (items.containsKey(item.getItemId())) {
            throw new StockException("Item already exists");
        }
        items.put(item.getItemId(), item);
    }

    public void removeItem(String itemId) {
        items.remove(itemId);
    }

    public Item getItem(String itemId) {
        return items.get(itemId);
    }

    public List<Item> getLowStockItems() {
        return items.values().stream()
                .filter(Item::isLowStock)
                .collect(Collectors.toList());
    }

    public int getTotalItems() {
        return items.size();
    }

    public String getWarehouseId() { return warehouseId; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId='" + warehouseId + '\'' +
                ", location='" + location + '\'' +
                ", totalItemTypes=" + items.size() +
                '}';
    }
}
