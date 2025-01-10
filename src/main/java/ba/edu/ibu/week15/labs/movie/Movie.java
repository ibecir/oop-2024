package ba.edu.ibu.week15.labs.movie;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFormat {
    TextFormatter text_format() default TextFormatter.ORDINARY;
    NumberFormatter number_format() default NumberFormatter.CURRENCY;
}

public class Movie {
    @FieldFormat
    private Date releaseDate;

    @FieldFormat(text_format = TextFormatter.ORDINARY)
    private String title;

    @FieldFormat(number_format = NumberFormatter.CURRENCY)
    private double boxOffice;

    @FieldFormat(number_format = NumberFormatter.PERCENTAGE)
    private double rating;

    @FieldFormat(text_format = TextFormatter.UPPER_CASE)
    private String genre;

    @FieldFormat(text_format = TextFormatter.UPPER_CASE)
    private String director;

    @FieldFormat(text_format = TextFormatter.LOWER_CASE)
    private String language;

    public Movie(MovieBuilder builder) {
        this.releaseDate = builder.releaseDate;
        this.title = builder.title;
        this.boxOffice = builder.boxOffice;
        this.rating = builder.rating;
        this.genre = builder.genre;
        this.director = builder.director;
        this.language = builder.language;
    }

    public String getTitle() {
        return title;
    }

    public static class MovieBuilder {
        private Date releaseDate;
        private String title;
        private double boxOffice;
        private double rating;
        private String genre;
        private String director;
        private String language;

        public MovieBuilder setReleaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setBoxOffice(double boxOffice) {
            this.boxOffice = boxOffice;
            return this;
        }

        public MovieBuilder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public MovieBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder setDirector(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}

