package ba.edu.ibu.week7.preparation.inventorymanagement;

interface Sellable {
    double calculateDiscount(double discountRate);
    String getDescription();
}
