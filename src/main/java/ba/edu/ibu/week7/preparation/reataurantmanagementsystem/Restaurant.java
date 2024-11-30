package ba.edu.ibu.week7.preparation.reataurantmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private String restaurantName;
    private List<Customer> customers;
    private Map<String, MenuItem> menuItems;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
        this.customers = new ArrayList<>();
        this.menuItems = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addMenuItem(MenuItem item) {
        menuItems.put(item.getCode(), item);
    }

    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayMenu() {
        for (MenuItem item : menuItems.values()) {
            System.out.println(item.getDescription());
        }
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (Customer customer : customers) {
            for (TableReservation<? extends MenuItem> reservation : customer.getReservations()) {
                totalSales += reservation.calculateTotalAmount();
            }
        }
        return totalSales;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Map<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
