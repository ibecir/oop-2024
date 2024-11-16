package ba.edu.ibu.week7.labs;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + " (Price: " + price + ", Quantity: " + quantity + ")";
    }
}

interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}

class PercentageDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, int quantity) {
        return price * 0.90; // 10% discount
    }
}

class FixedDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, int quantity) {
        return Math.max(price - 50.0, 0.0); // Fixed discount of $50
    }
}

class BulkDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price, int quantity) {
        return quantity > 3 ? price * 0.80 : price; // 20% discount for quantity > 3
    }
}

public class Task1 {

    public static double calculateTotalDiscountedPrice(List<Product> products, DiscountStrategy strategy) {
        double total = 0.0;
        for (Product product : products) {
            total += strategy.applyDiscount(product.getPrice(), product.getQuantity());
        }
        return total;
    }

    public static double calculateOriginalTotalPrice(List<Product> products) {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1000.0, 1));
        products.add(new Product("Phone", 500.0, 2));
        products.add(new Product("Tablet", 300.0, 5));

        DiscountStrategy percentageDiscount = new PercentageDiscount();
        DiscountStrategy fixedDiscount = new FixedDiscount();
        DiscountStrategy bulkDiscount = new BulkDiscount();

        System.out.println("Original Total Price: " + calculateOriginalTotalPrice(products));

        System.out.println("Total Price after Percentage Discount: " +
                calculateTotalDiscountedPrice(products, percentageDiscount));

        System.out.println("Total Price after Fixed Discount: " +
                calculateTotalDiscountedPrice(products, fixedDiscount));

        System.out.println("Total Price after Bulk Discount: " +
                calculateTotalDiscountedPrice(products, bulkDiscount));
    }
}
