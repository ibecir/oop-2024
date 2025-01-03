package ba.edu.ibu.week13.labs.factory;

public class CreditCardPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment...");
    }
}
