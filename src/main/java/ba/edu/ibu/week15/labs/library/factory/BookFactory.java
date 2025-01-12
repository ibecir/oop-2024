package ba.edu.ibu.week15.labs.library.factory;

import ba.edu.ibu.week15.labs.library.Book;
import ba.edu.ibu.week15.labs.library.enums.AvailabilityStatus;
import ba.edu.ibu.week15.labs.library.exceptions.InvalidBookException;

import java.util.Date;

public interface BookFactory {
    Book createBook(String isbn, String title, String author, Date publicationDate,
                    double price, AvailabilityStatus availability) throws InvalidBookException;
}
