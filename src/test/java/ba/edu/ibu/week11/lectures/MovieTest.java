package ba.edu.ibu.week11.lectures;

import ba.edu.ibu.week15.labs.movie.InvalidMovieDataException;
import ba.edu.ibu.week15.labs.movie.Movie;
import ba.edu.ibu.week15.labs.movie.MovieLoader;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {
    private List<Movie> movies;

    @BeforeEach
    public void setUp() {
        movies = MovieLoader.loadMovies("movies.csv");
    }

    @Test
    public void ifValuesEmpty_ThrowCustomException() {
        assertThrows(InvalidMovieDataException.class, () -> {
            MovieLoader.loadMovies("invalid-movies.csv");
        });
    }

    @Test
    public void ifFileLoaded_assertMultipleConditions() {
        assertAll(
                () -> assertEquals("Barbie", movies.get(0).getTitle()),
                () -> assertEquals(2, movies.size())
        );
    }

    @Test
    public void ifFileDoesNotExist_assertCauseIsFileNotFoundException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            MovieLoader.loadMovies("non-existent.csv");
        });
        assertTrue(exception.getCause() instanceof FileNotFoundException);
    }
}

