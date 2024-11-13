package ba.edu.ibu.week7.preparation.inventorymanagement;

import java.util.Date;
import java.util.Map;

public class MainRun {
    public static void main(String[] args) {
        // Create some Milk and Honey items
        Milk milk1 = new Milk("001", "Meggle Milk", 2.5, 3.5);
        Milk milk2 = new Milk("002", "Farm Fresh Milk", 2.0, 2.0);
        Honey honey1 = new Honey("003", "Pure Honey", 15.0, HoneyType.BAGREMOV);
        Honey honey2 = new Honey("004", "Wild Honey", 18.0, HoneyType.LIVADSKI);

        Order<Item> myItems = new Order<>("Moja narudzba", new Date());
        myItems.addItem(milk1, 2);
        myItems.addItem(honey1, 2);

        // Create orders for milk and honey
        Order<Milk> milkOrder = new Order<>("Order1", new Date());
        milkOrder.addItem(milk1, 3);
        milkOrder.addItem(milk2, 5);

        Order<Honey> honeyOrder = new Order<>("Order2", new Date());
        honeyOrder.addItem(honey1, 2);
        honeyOrder.addItem(honey2, 1);

        // Create a person and add both milk and honey orders
        Person customer = new Person("John Doe", 30);
        customer.addOrder(milkOrder);
        customer.addOrder(honeyOrder);

        // Display each customer's order details and calculate total amounts
        System.out.println("Customer: " + customer.getName());
        for (Order<? extends Item> order : customer.getOrders()) {
            System.out.println("Order No: " + order.getOrderNo());
            for (Map.Entry<? extends Item, Integer> entry : order.getItems().entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(item.getDescription() + ", Quantity: " + quantity);
            }
            System.out.println("Total amount for " + order.getOrderNo() + ": " + order.calculateTotalAmount());
            System.out.println();
        }
    }
}
