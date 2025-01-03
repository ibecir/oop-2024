package ba.edu.ibu.week13.labs.factory;

public class PayPalPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}
