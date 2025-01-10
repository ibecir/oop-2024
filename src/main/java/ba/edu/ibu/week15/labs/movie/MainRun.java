package ba.edu.ibu.week15.labs.movie;

import java.util.List;

public class MainRun {
    public static void main(String[] args) {
        String inputFileName = "movies.csv";
        String outputFileName = "movies-report.csv";

        List<Movie> movies = MovieLoader.loadMovies(inputFileName);
        ReportWriter.generateReport(outputFileName, movies);
    }
}
