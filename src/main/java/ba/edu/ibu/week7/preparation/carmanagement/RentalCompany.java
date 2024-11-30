package ba.edu.ibu.week7.preparation.carmanagement;

import java.util.*;

public class RentalCompany {
    private String companyName;
    private List<Customer> customers = new ArrayList<>();
    private Map<String, Vehicle> vehicleInventory = new HashMap<>();

    public RentalCompany(String companyName) {
        this.companyName = companyName;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleInventory.put(vehicle.getVehicleId(), vehicle);
    }

    public Customer getCustomer(String customerId) {
        // example of streams implementation or basic below
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);

        /*for(Customer c : customers){
            if(c.getCustomerId() == customerId){
                return c;
            }
        }
        return null;*/
    }

    public void displayInventory() {
        Collection<Vehicle> vehiclesInInventory = vehicleInventory.values();
        for(Vehicle v : vehiclesInInventory){
            System.out.println(v.getDescription());
        }
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0;

        for (Customer customer : customers) {
            for (RentalTransaction<? extends Vehicle> transaction : customer.getRentalHistory()) {
                totalRevenue += transaction.calculateTotalAmount();
            }
        }
        return totalRevenue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(Map<String, Vehicle> vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }
}
