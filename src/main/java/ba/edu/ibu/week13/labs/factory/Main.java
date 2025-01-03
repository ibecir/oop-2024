package ba.edu.ibu.week13.labs.factory;

public class Main {
    public static void main(String[] args) {
        // Use payment factories to create payment objects
        PaymentFactory paymentFactory = new PaymentFactory();
        Payment creditCardPayment = paymentFactory.createPayment("creditCard");
        creditCardPayment.processPayment();

        Payment paypalPayment = paymentFactory.createPayment("paypal");
        paypalPayment.processPayment();
    }
}
