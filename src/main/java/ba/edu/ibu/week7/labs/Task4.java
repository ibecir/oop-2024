package ba.edu.ibu.week7.labs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Sale {
    private String productName;
    private String productCategory;
    private double saleAmount;
    private LocalDate saleDate;

    public Sale(String productName, String productCategory, double saleAmount, LocalDate saleDate) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.saleAmount = saleAmount;
        this.saleDate = saleDate;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", saleAmount=" + saleAmount +
                ", saleDate=" + saleDate +
                '}';
    }
}

class SalesReport {

    public void generateReport(List<Sale> sales) {
        System.out.println("Full Sales Report:");
        double totalRevenue = 0.0;
        double totalSales = 0.0;
        int count = 0;

        for (Sale sale : sales) {
            totalRevenue += sale.getSaleAmount();
            count++;
            System.out.println(sale);
        }

        totalSales = count > 0 ? totalRevenue / count : 0.0;
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Sale: $" + totalSales);
    }

    public void generateReport(List<Sale> sales, String productCategory) {
        System.out.println("Sales Report for Category: " + productCategory);
        double totalCategoryRevenue = 0.0;
        int count = 0;

        for (Sale sale : sales) {
            if (sale.getProductCategory().equalsIgnoreCase(productCategory)) {
                totalCategoryRevenue += sale.getSaleAmount();
                count++;
                System.out.println(sale);
            }
        }

        double averageCategorySales = count > 0 ? totalCategoryRevenue / count : 0.0;
        System.out.println("Total Revenue for Category: $" + totalCategoryRevenue);
        System.out.println("Average Sale for Category: $" + averageCategorySales);
    }

    public void generateReport(List<Sale> sales, LocalDate startDate, LocalDate endDate) {
        System.out.println("Sales Report from " + startDate + " to " + endDate);
        double totalRevenueInRange = 0.0;
        int count = 0;

        for (Sale sale : sales) {
            if (!sale.getSaleDate().isBefore(startDate) && !sale.getSaleDate().isAfter(endDate)) {
                totalRevenueInRange += sale.getSaleAmount();
                count++;
                System.out.println(sale);
            }
        }

        double averageSalesInRange = count > 0 ? totalRevenueInRange / count : 0.0;
        System.out.println("Total Revenue in Range: $" + totalRevenueInRange);
        System.out.println("Average Sale in Range: $" + averageSalesInRange);
    }
}

public class Task4 {
    public static void main(String[] args) {
        // Sample sales data
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale("Laptop", "Electronics", 1200.0, LocalDate.of(2024, 1, 10)));
        sales.add(new Sale("Headphones", "Electronics", 200.0, LocalDate.of(2024, 2, 15)));
        sales.add(new Sale("Desk Chair", "Furniture", 150.0, LocalDate.of(2024, 3, 20)));
        sales.add(new Sale("Coffee Table", "Furniture", 300.0, LocalDate.of(2024, 3, 25)));
        sales.add(new Sale("Blender", "Home Appliances", 100.0, LocalDate.of(2024, 4, 5)));
        sales.add(new Sale("Refrigerator", "Home Appliances", 800.0, LocalDate.of(2024, 5, 12)));

        SalesReport report = new SalesReport();

        report.generateReport(sales);

        report.generateReport(sales, "Electronics");

        report.generateReport(sales, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 31));
    }
}

