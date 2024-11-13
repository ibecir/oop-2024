package ba.edu.ibu.week7.preparation.delete;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order <T extends Item & Sellable>{
    private String orderNo;
    private Date createdAt;
    private HashMap<T, Integer> items;

    public Order(String orderNo, Date createdAt, HashMap<T, Integer> items) {
        this.orderNo = orderNo;
        this.createdAt = createdAt;
        this.items = items;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public HashMap<T, Integer> getQuantity() {
        return items;
    }

    public void setQuantity(HashMap<T, Integer> quantity) {
        this.items = quantity;
    }

    public void addItem(T item, int quantity) {
        boolean itemExists = false;

        for(T existingItem : this.items.keySet()){
            if(existingItem.getBarcode().equals(item.getBarcode())){
                this.items.put(existingItem, this.items.get(existingItem) + quantity);
                break;
            }
        }

        if(!itemExists) {
            items.put(item, quantity);
        }
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for(Map.Entry<T, Integer> entry: this.items.entrySet()){
            totalAmount += entry.getKey().getPrice() * entry.getValue();
        }
        return totalAmount;
    }
}
