package ba.edu.ibu.week15.labs.movie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// Data Loading
public class MovieLoader {
    public static List<Movie> loadMovies(String fileName) {
        List<Movie> movies = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header
                }

                String[] fields = line.split(",");
                if (fields.length < 7 || fields[1].isEmpty() || fields[2].isEmpty() || fields[3].isEmpty()) {
                    throw new InvalidMovieDataException("Invalid data", new ClassCastException("Values are empty"));
                }

                movies.add(new Movie.MovieBuilder()
                        .setReleaseDate(sdf.parse(fields[0]))
                        .setTitle(fields[1])
                        .setBoxOffice(Double.parseDouble(fields[2]))
                        .setRating(Double.parseDouble(fields[3]))
                        .setGenre(fields[4])
                        .setDirector(fields[5])
                        .setLanguage(fields[6])
                        .build());
            }
        } catch (FileNotFoundException e) {
            throw new InvalidMovieDataException("File not found: " + fileName, e);
        } catch (Exception e) {
            throw new InvalidMovieDataException("Error processing file: " + fileName, e);
        }

        return movies;
    }
}
