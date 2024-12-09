package ba.edu.ibu.week10.task4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Shape of You", "Ed Sheeran", "Pop"));
        playlist.add(new Song("Bohemian Rhapsody", "Queen", "Rock"));
        playlist.add(new Song("Blinding Lights", "The Weeknd", "Pop"));
        playlist.add(new Song("Smells Like Teen Spirit", "Nirvana", "Rock"));
        playlist.add(new Song("Someone Like You", "Adele", "Ballad"));

        String targetGenre = "Pop";

        GenreFilterIterator genreIterator = new GenreFilterIterator(playlist.toArray(new Song[0]), targetGenre);

        System.out.println("Songs in the genre '" + targetGenre + "':");
        while (genreIterator.hasNext()) {
            Song song = genreIterator.next();
            System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist() + ", Genre: " + song.getGenre());
        }
    }
}
