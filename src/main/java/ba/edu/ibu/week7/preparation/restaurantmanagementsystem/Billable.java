package ba.edu.ibu.week7.preparation.restaurantmanagementsystem;

public interface Billable {
    double applyDiscount(double discountRate);
    String getDescription();
}
