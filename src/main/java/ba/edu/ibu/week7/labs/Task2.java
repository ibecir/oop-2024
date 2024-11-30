package ba.edu.ibu.week7.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private String status;

    public Book(String title, String author, String ISBN, String status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}


class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> findBookByISBN(String ISBN) {
        return books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst();
    }
}

public class Task2 {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890", "Available"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9876543210", "Checked Out"));
        library.addBook(new Book("1984", "George Orwell", "1122334455", "Reserved"));

        // Test cases for finding books
        String searchISBN = "1234567890";
        String missingISBN = "0000000000";

        Book book1 = library.findBookByISBN(missingISBN)
                .orElse(new Book("Default Title", "Default Author", "0000000000", "Unavailable"));
        System.out.println("Using orElse: " + book1);

        Book book2 = library.findBookByISBN(missingISBN)
                .orElseGet(() -> new Book("Lazy Default Title", "Lazy Default Author", "0000000000", "Unavailable"));
        System.out.println("Using orElseGet: " + book2);

        Optional<Book> optionalBook = library.findBookByISBN(missingISBN);
        if (optionalBook.isPresent()) {
            System.out.println("Found Book: " + optionalBook.get());
        } else {
            System.out.println("Book with ISBN " + missingISBN + " not found. Please try another ISBN.");
        }

        optionalBook = library.findBookByISBN(searchISBN);
        if (optionalBook.isPresent()) {
            System.out.println("Found Book: " + optionalBook.get());
        } else {
            System.out.println("Book with ISBN " + searchISBN + " not found. Please try another ISBN.");
        }
    }
}
