package ba.edu.ibu.week7.preparation.carmanagement;

import java.util.*;

public abstract class Vehicle implements Rentable{
    private String vehicleId;
    private String name;
    private double rentalRate;
    private HashMap<Date, Integer> kilometersRecord;

    public Vehicle(String vehicleId, String name, double rentalRate) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.rentalRate = rentalRate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Override
    public double applyDiscount(double discountRate){
        // the multiplication in brackets will count the discount based on the price
        // e.g. rentalRate = 20, discountRate=0.2 (20%), discount amount will be 20*0.2=4
        return this.rentalRate - (this.rentalRate * discountRate);
    }

    @Override
    public String getDescription(){
        return "Vehicle ID is: " + this.vehicleId + ", name: " + this.name + ", and rental rate: " + this.rentalRate;
    }

    public void addKilometers(Date rentalDate, int kilometers){
        this.kilometersRecord.put(rentalDate, kilometers);
    }

    public int getTotalKilometers(){
        int totalKilometers = 0;
        Collection<Integer> kilometers = this.kilometersRecord.values();
        for(Integer k : kilometers){
            totalKilometers += k;
        }
        return totalKilometers;
    }
}
