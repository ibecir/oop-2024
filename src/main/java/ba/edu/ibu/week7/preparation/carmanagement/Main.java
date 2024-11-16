package ba.edu.ibu.week7.preparation.carmanagement;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        RentalCompany company = new RentalCompany("Advanced Rentals");

        Car car = new Car("C001", "Toyota Corolla", 50, CarType.SEDAN, "Petrol");
        Motorcycle motorcycle = new Motorcycle("M001", "Yamaha R3", 30, 321);

        company.addVehicle(car);
        company.addVehicle(motorcycle);

        Customer customer = new Customer("CU001", "Alice Smith", "123-456-7890");

        RentalTransaction<Car> carRental = new RentalTransaction<>("T001", new Date(), 1);
        carRental.addVehicleToRental(car, 3);

        RentalTransaction<Motorcycle> motorcycleRental = new RentalTransaction<>("T002", new Date(), 1);
        motorcycleRental.addVehicleToRental(motorcycle, 5);

        customer.addRentalTransaction(carRental);
        customer.addRentalTransaction(motorcycleRental);

        company.addCustomer(customer);

        company.displayInventory();

        System.out.println("Total Revenue: $" + company.calculateTotalRevenue());
    }
}