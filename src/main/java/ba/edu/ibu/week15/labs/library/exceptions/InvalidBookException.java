package ba.edu.ibu.week15.labs.library.exceptions;

public class InvalidBookException extends RuntimeException {

    public InvalidBookException(String message) {
        super(message);
    }

    public InvalidBookException(String message, Throwable cause) {
        super(message, cause);
    }
}
