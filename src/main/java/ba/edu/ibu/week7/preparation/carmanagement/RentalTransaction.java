package ba.edu.ibu.week7.preparation.carmanagement;

import java.util.Date;
import java.util.HashMap;

public class RentalTransaction<T extends Vehicle & Rentable>{
    private String transactionId;
    private Date rentalDate;
    private HashMap<T, Integer> rentedVehicles;
    private int customerId;

    public RentalTransaction(String transactionId, Date rentalDate, int customerId){
        this.transactionId = transactionId;
        this.rentalDate = rentalDate;
        this.customerId = customerId;
    }

    public void addVehicleToRental(T vehicle, int days) {
        if (rentedVehicles.containsKey(vehicle)) {
            // If the vehicle already exists, add the new days to the existing days
            int existingDays = rentedVehicles.get(vehicle);
            rentedVehicles.put(vehicle, existingDays + days);
        } else {
            // If the vehicle doesn't exist, add it to the map with the specified days
            rentedVehicles.put(vehicle, days);
        }
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (T vehicle : rentedVehicles.keySet()) {
            totalAmount += this.rentedVehicles.get(vehicle) * vehicle.getRentalRate();
        }
        return totalAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public HashMap<T, Integer> getRentedVehicles() {
        return rentedVehicles;
    }

    public void setRentedVehicles(HashMap<T, Integer> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
