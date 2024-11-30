package ba.edu.ibu.week7.preparation.reataurantmanagementsystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TableReservation<T extends MenuItem> {
    private String reservationId;
    private Date reservationDate;
    private HashMap<T, Integer> orderedItems;
    private int tableNumber;

    public TableReservation(String reservationId, Date reservationDate, int tableNumber) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        this.orderedItems = new HashMap<>();
    }

    public void addItemToOrder(T item, int quantity) {
        orderedItems.put(item, quantity);
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (Map.Entry<T, Integer> entry : orderedItems.entrySet()) {
            double itemPrice = entry.getKey().applyDiscount(0.1); // Assuming a 10% discount
            total += itemPrice * entry.getValue();
        }
        return total;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public HashMap<T, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(HashMap<T, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}