package ba.edu.ibu.week15.labs.movie;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }

    public InvalidMovieDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
