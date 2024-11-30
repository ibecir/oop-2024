package ba.edu.ibu.week7.preparation.reataurantmanagementsystem;

import java.util.Date;

public class MainApplication {
    public static void main(String[] args) {
        Dish pizza = new Dish("D001", "Pizza Margherita", 12.99, CuisineType.ITALIAN, "Tomato");
        Drink coke = new Drink("D002", "Coca-Cola", 2.99, 500);

        Restaurant restaurant = new Restaurant("Italian Bistro");

        restaurant.addMenuItem(pizza);
        restaurant.addMenuItem(coke);

        TableReservation<Dish> dishReservation = new TableReservation<>("R001", new Date(), 1);
        dishReservation.addItemToOrder(pizza, 2);

        TableReservation<Drink> drinkReservation = new TableReservation<>("R002", new Date(), 2);
        drinkReservation.addItemToOrder(coke, 3);

        Customer customer = new Customer("C001", "John Doe", "555-1234");

        customer.addReservation(dishReservation);
        customer.addReservation(drinkReservation);

        restaurant.addCustomer(customer);

        System.out.println("Customer: " + customer.getName());
        for (TableReservation<? extends MenuItem> reservation : customer.getReservations()) {
            System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("Table Number: " + reservation.getTableNumber());
            System.out.println("Total: $" + reservation.calculateTotalAmount());
        }

        System.out.println("\nRestaurant Menu:");
        restaurant.displayMenu();

        System.out.println("\nTotal Sales: $" + restaurant.calculateTotalSales());
    }
}