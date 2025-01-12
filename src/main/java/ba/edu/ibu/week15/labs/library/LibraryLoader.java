package ba.edu.ibu.week15.labs.library;

import ba.edu.ibu.week15.labs.library.enums.AvailabilityStatus;
import ba.edu.ibu.week15.labs.library.enums.BookCategory;
import ba.edu.ibu.week15.labs.library.exceptions.InvalidBookException;
import ba.edu.ibu.week15.labs.library.factory.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryLoader {

    public static List<Book> loadBooks(String fileName) {
        List<Book> books = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String line;
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
            lineNumber++;
            if (line == null) {
                throw new InvalidBookException("CSV file is empty");
            }

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] fields = line.split(",");

                if (fields.length != 7) { // Expected fields: isbn, title, author, publicationDate, category, price, availability
                    throw new InvalidBookException("Invalid number of fields at line " + lineNumber);
                }

                String isbn = fields[0].trim();
                String title = fields[1].trim();
                String author = fields[2].trim();
                String publicationDateStr = fields[3].trim();
                String categoryStr = fields[4].trim().toUpperCase();
                String priceStr = fields[5].trim();
                String availabilityStr = fields[6].trim().toUpperCase();

                if (isbn.isEmpty() || title.isEmpty() || author.isEmpty()) {
                    throw new InvalidBookException("Missing mandatory field at line " + lineNumber, new ClassCastException());
                }

                Date publicationDate;
                try {
                    publicationDate = sdf.parse(publicationDateStr);
                } catch (Exception e) {
                    throw new InvalidBookException("Invalid publication date at line " + lineNumber, e);
                }

                if (publicationDate.after(new Date())) {
                    throw new InvalidBookException("Publication date is in the future at line " + lineNumber, new ClassCastException());
                }

                BookCategory category;
                if (!categoryStr.isEmpty()) {
                    try {
                        category = BookCategory.valueOf(categoryStr);
                    } catch (IllegalArgumentException e) {
                        throw new InvalidBookException("Invalid book category at line " + lineNumber, e);
                    }
                } else {
                    category = BookCategory.FICTION;
                }

                double price;
                try {
                    price = Double.parseDouble(priceStr);
                    if (price < 0) {
                        throw new InvalidBookException("Negative price at line " + lineNumber, new ClassCastException());
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidBookException("Invalid price format at line " + lineNumber, e);
                }

                AvailabilityStatus availability;
                if (!availabilityStr.isEmpty()) {
                    try {
                        availability = AvailabilityStatus.valueOf(availabilityStr);
                    } catch (IllegalArgumentException e) {
                        throw new InvalidBookException("Invalid availability status at line " + lineNumber, e);
                    }
                } else {
                    availability = AvailabilityStatus.AVAILABLE;
                }

                BookFactory factory;
                switch (category) {
                    case FICTION:
                        factory = new FictionBookFactory();
                        break;
                    case NON_FICTION:
                        factory = new NonFictionBookFactory();
                        break;
                    case SCIENCE:
                        factory = new ScienceBookFactory();
                        break;
                    case ARTS:
                        factory = new ArtsBookFactory();
                        break;
                    case HISTORY:
                        factory = new HistoryBookFactory();
                        break;
                    case TECHNOLOGY:
                        factory = new TechnologyBookFactory();
                        break;
                    default:
                        factory = new FictionBookFactory(); // Default
                        break;
                }

                Book book = factory.createBook(isbn, title, author, publicationDate, price, availability);
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }

        return books;
    }
}
