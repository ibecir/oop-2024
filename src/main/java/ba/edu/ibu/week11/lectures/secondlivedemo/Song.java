package ba.edu.ibu.week11.lectures.secondlivedemo;

public record Song(
        int id,
        String name,
        String artistName,
        String genre,
        double length,
        double popularity
) {
}
