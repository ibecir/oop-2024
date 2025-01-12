package ba.edu.ibu.week15.labs.library;

import ba.edu.ibu.week15.labs.library.exceptions.InvalidBookException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Book> books = LibraryLoader.loadBooks("books.csv");
            LibraryReportGenerator.generateReport("library_report.csv", books);

            System.out.println("Library report generated successfully.");
        } catch (InvalidBookException e) {
            System.err.println("Error processing books: " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
