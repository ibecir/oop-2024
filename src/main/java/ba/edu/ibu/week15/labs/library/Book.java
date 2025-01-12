package ba.edu.ibu.week15.labs.library;

import ba.edu.ibu.week15.labs.library.annotations.FieldValidation;
import ba.edu.ibu.week15.labs.library.enums.AvailabilityStatus;
import ba.edu.ibu.week15.labs.library.enums.BookCategory;

import java.util.Date;

public class Book {
    @FieldValidation
    private String isbn;

    @FieldValidation
    private String title;

    @FieldValidation
    private String author;

    @FieldValidation
    private Date publicationDate;

    @FieldValidation
    private BookCategory category;

    @FieldValidation
    private double price;

    @FieldValidation
    private AvailabilityStatus availability;

    public Book(String isbn, String title, String author, Date publicationDate,
                BookCategory category, double price, AvailabilityStatus availability) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.category = category;
        this.price = price;
        this.availability = availability;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AvailabilityStatus getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityStatus availability) {
        this.availability = availability;
    }
}

