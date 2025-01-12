package ba.edu.ibu.week15.labs.library.factory;

import ba.edu.ibu.week15.labs.library.Book;
import ba.edu.ibu.week15.labs.library.enums.AvailabilityStatus;
import ba.edu.ibu.week15.labs.library.enums.BookCategory;
import ba.edu.ibu.week15.labs.library.exceptions.InvalidBookException;

import java.util.Date;

public class FictionBookFactory implements BookFactory {
    @Override
    public Book createBook(String isbn, String title, String author, Date publicationDate,
                           double price, AvailabilityStatus availability) throws InvalidBookException {
        return new Book(isbn, title, author, publicationDate, BookCategory.FICTION, price, availability);
    }
}
