package ba.edu.ibu.week7.preparation.inventorymanagement;

import java.util.*;

class Order<T extends Item & Sellable> {
    private String orderNo;
    private Date createAt;
    private HashMap<T, Integer> items;

    public Order(String orderNo, Date createAt) {
        this.orderNo = orderNo;
        this.createAt = createAt;
        this.items = new HashMap<>();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public HashMap<T, Integer> getItems() {
        return items;
    }

    public void addItem(T item, int quantity) {
        boolean itemExists = false;

        // Check if an item with the same barcode already exists in the map
        for (T existingItem : items.keySet()) {
            if (existingItem.getBarcode().equals(item.getBarcode())) {
                // Item exists, update the quantity
                items.put(existingItem, items.get(existingItem) + quantity);
                itemExists = true;
                break;
            }
        }

        // If the item does not exist, add it to the map
        if (!itemExists) {
            items.put(item, quantity);
        }
    }

    public double calculateTotalAmount() {
        double total = 0.0;
        for (Map.Entry<T, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
