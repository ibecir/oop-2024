package ba.edu.ibu.week15.labs.invoice_management;

public class InvalidInvoiceException extends RuntimeException {
    public InvalidInvoiceException(String message) {
        super(message);
    }

    public InvalidInvoiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

