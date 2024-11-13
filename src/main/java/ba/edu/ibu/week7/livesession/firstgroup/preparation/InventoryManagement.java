package ba.edu.ibu.week7.livesession.firstgroup.preparation;

import java.sql.ClientInfoStatus;
import java.util.*;

enum HoneyType {
    BAGREM, LIVADA, KESTEN
}

interface Sellable {
    double calculateDiscount(double discountRate);
    String getDescription();
}

abstract class Item implements Sellable{
    private String barcode;
    private String name;
    private double price;

    public Item(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription(){
        return "Barcode: " + this.barcode + ", Name: " + this.name + ", Price: " + price;
    }

    @Override
    public double calculateDiscount(double discountRate){
        return this.price * discountRate / 100;
    }
}

class Milk extends Item{
    private double fat;

    public Milk(String barcode, String name, double price, double fat) {
        super(barcode, name, price);
        this.fat = fat;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Fat: " + this.fat;
    }
}

class Honey extends Item {
    private HoneyType honeyType;

    public Honey(String barcode, String name, double price, HoneyType honeyType) {
        super(barcode, name, price);
        this.honeyType = honeyType;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Honey Type: " + this.honeyType;
    }
}

class Order<T extends Item & Sellable> {
    private String orderNumber;
    private Date createdAt;
    private HashMap<T, Integer> items;

    public Order(String orderNumber, Date createdAt) {
        this.orderNumber = orderNumber;
        this.createdAt = createdAt;
        this.items = new HashMap<>();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public HashMap<T, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<T, Integer> items) {
        this.items = items;
    }

    public void addItem(T item, int quantity){
        if(items.containsKey(item)){
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;

        for(Map.Entry<T, Integer> entry : this.items.entrySet()){
            totalAmount += entry.getValue() * entry.getKey().getPrice();
        }

        return totalAmount;
    }

    @Override
    public String toString() {
        String orderDetails = "Order No: " + this.orderNumber + ", Date: " + this.createdAt;
        for(Map.Entry<T, Integer> entry : this.items.entrySet()){
            orderDetails += "\nItem: " + entry.getKey().getName() + ", Quantity: " + entry.getValue();
        }
        return orderDetails;
    }
}

class Person {
    private String name;
    private int age;
    private List<Order<? extends Item>> orders;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order<? extends Item>> getOrders() {
        return orders;
    }

    public void setOrders(List<Order<? extends Item>> orders) {
        this.orders = orders;
    }

    public void addOrder(Order<? extends Item> order){
        this.orders.add(order);
    }
}

class InventoryManagement {
    public static void main(String[] args) {
        Order<Item> order = new Order<>("123", new Date());
        Item milk = new Milk("123", "Mlijeko", 3.12, 3.13);
        Item med = new Honey("333", "Med", 10.15, HoneyType.KESTEN);

        // Test the method addItem
        order.addItem(milk, 1);
        order.addItem(med, 1);
        order.addItem(milk, 1);

        Person person = new Person("Becir", 30);
        person.addOrder(order);

        Order<Item> secondOrder = new Order<>("12312", new Date());
        secondOrder.addItem(new Milk("123123", "Meggle", 3.13, 28.12), 3);

        person.addOrder(secondOrder);
        for(Order o : person.getOrders()){
            System.out.println(o);
        }
    }
}
