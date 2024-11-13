package ba.edu.ibu.week7.livesession.secondgroup.midtermpreparation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public double calculateDiscount(double discountRate){
        return this.price * discountRate / 100;
    }

    @Override
    public String getDescription(){
        return "Barcode: " + this.barcode + ", Name: " + this.name + ", Price: " + this.price;
    }
}

class Milk extends Item {
    private double fat;

    public Milk(String barcode, String name, double price, double fat) {
        super(barcode, name, price);
        this.fat = fat;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Fat: " + this.fat;
    }
}

class Honey extends Item {
    private HoneyType type;

    public Honey(String barcode, String name, double price, HoneyType type){
        super(barcode, name, price);
        this.type = type;
    }

    public HoneyType getType(){
        return this.type;
    }

    public void setType(HoneyType type){
        this.type = type;
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Honey Type: " + this.type;
    }
}

class Order<T extends Item & Sellable> {
    private String orderNo;
    private Date createAt;
    private HashMap<T, Integer> items;

    public Order(String orderNo, Date createAt) {
        this.orderNo = orderNo;
        this.createAt = createAt;
        this.items = new HashMap<>();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public HashMap<T, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<T, Integer> items) {
        this.items = items;
    }

    // If item is already in the order just update the quantities
    public void addItem(T item, int quantity){
        if(this.items.containsKey(item))
            this.items.put(item, this.items.get(item) + quantity);
        else
            this.items.put(item, quantity);
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for(Map.Entry<T, Integer> entry : this.items.entrySet()){
            totalAmount += entry.getKey().getPrice() * entry.getValue();
        }
        return totalAmount;
    }
}

class Person {
    private String name;
    private int age;
    private List<Order<? extends Item>> orders; // private List<Order>

    public Person(String name, int age, List<Order<? extends Item>> orders) {
        this.name = name;
        this.age = age;
        this.orders = orders;
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