package ba.edu.ibu.week13.labs.factory;

public class PaymentFactory {
    public Payment createPayment(String paymentType) {
        if (paymentType == null || paymentType.equals("")) {
            return null;
        }
        switch (paymentType) {
            case "paypal":
                return new PayPalPayment();
            case "creditCard":
                return new CreditCardPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
    }
}
