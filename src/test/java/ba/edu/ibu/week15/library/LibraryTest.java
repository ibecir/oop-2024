package ba.edu.ibu.week15.library;

import ba.edu.ibu.week15.labs.library.Book;
import ba.edu.ibu.week15.labs.library.LibraryLoader;
import ba.edu.ibu.week15.labs.library.LibraryReportGenerator;
import ba.edu.ibu.week15.labs.library.enums.AvailabilityStatus;
import ba.edu.ibu.week15.labs.library.enums.BookCategory;
import ba.edu.ibu.week15.labs.library.exceptions.InvalidBookException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private List<Book> books;


    @BeforeEach
    public void setUp() {
        books = LibraryLoader.loadBooks("test_books.csv");
    }

    @Test
    public void testMissingFields_ThrowInvalidBookException() {
        assertThrows(InvalidBookException.class, () -> {
            LibraryLoader.loadBooks("test_missing_fields.csv");
        }, "Expected InvalidBookException due to missing mandatory fields.");
    }

    @Test
    public void testInvalidData_ThrowInvalidBookException() {
        assertThrows(InvalidBookException.class, () -> {
            LibraryLoader.loadBooks("test_invalid_data.csv");
        }, "Expected InvalidBookException due to invalid data entries.");
    }

    @Test
    public void testLoadBooks_VerifyDataIntegrity() {
        Assertions.assertNotNull(books, "Books list should not be null.");

        Assertions.assertEquals(3, books.size(), "Books list size should be 3.");

        Book firstBook = books.get(0);
        Assertions.assertEquals("ISBN-001", firstBook.getIsbn(), "First book ISBN mismatch.");
        Assertions.assertEquals("Effective Java", firstBook.getTitle(), "First book title mismatch.");
        Assertions.assertEquals("Joshua Bloch", firstBook.getAuthor(), "First book author mismatch.");
        Assertions.assertEquals(BookCategory.SCIENCE, firstBook.getCategory(), "First book category mismatch.");
        Assertions.assertEquals(50.00, firstBook.getPrice(), 0.001, "First book price mismatch.");
        Assertions.assertEquals(AvailabilityStatus.AVAILABLE, firstBook.getAvailability(), "First book availability mismatch.");
    }

    @Test
    public void testGenerateReport_FileCreation() {
        String outputFileName = "test_library_report.csv";
        LibraryReportGenerator.generateReport(outputFileName, books);

        File reportFile = new File(outputFileName);
        Assertions.assertTrue(reportFile.exists(), "Report file should exist.");

        try {
            List<String> lines = Files.readAllLines(Paths.get(outputFileName));
            Assertions.assertEquals(4, lines.size(), "Report should have 4 lines (1 header + 3 data).");
            String header = lines.get(0);
            Assertions.assertEquals("ISBN,TITLE,AUTHOR,PUBLICATIONDATE,CATEGORY,PRICE,AVAILABILITY", header, "Header mismatch.");
        } catch (Exception e) {
            Assertions.fail("Exception reading report file: " + e.getMessage());
        }

        reportFile.delete();
    }

    @Test
    public void testFileNotFound_ThrowRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            LibraryLoader.loadBooks("non_existent_file.csv");
        }, "Expected RuntimeException due to non-existent file.");
    }
}
