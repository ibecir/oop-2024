package ba.edu.ibu.week7.preparation.reataurantmanagementsystem;

import ba.edu.ibu.week7.preparation.restaurantmanagementsystem.Billable;

abstract class MenuItem implements Billable {
    protected String code;
    protected String name;
    protected double price;

    public MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public double applyDiscount(double discountRate) {
        return price * (1 - discountRate);
    }

    @Override
    public String getDescription() {
        return "Name: " + name + ", Price: $" + price;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
