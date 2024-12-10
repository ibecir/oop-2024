package ba.edu.ibu.week11.lectures.livesessions.secondgroup.problem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        SongsProcessingSystem system = new SongsProcessingSystem("/Users/becir/Documents/Academic Materials/IBU/2024-2025/FALL/Object Oriented Programming/Projects/oop-2024/src/main/java/ba/edu/ibu/week11/lectures/codingproblem/songs.csv");
        Optional<Song> s = system.getSongById(2);
        if(s.isPresent())
            System.out.println(s.get());

        Song song = system.getMostPopularSong();
    }
}

// 1. Create a record Song
// 2. Read the file to the List DS as an attribute to the class SongsProcessingSystem
// 3. Provide implementations for different function, 3 of them\
// 4. Make tests
public class SongsProcessingSystem {
    private List<Song> songs;

    public SongsProcessingSystem(String filename) {
        try {
            this.songs = readFile(filename);
        } catch (Exception e) {
            System.out.println("Problem with reading the file!");
        } finally {
            this.songs = new ArrayList<>();
        }
    }

    public Optional<Song> getSongById(int id){
        for (Song tmpSong : this.songs){
            if(tmpSong.id() == id)
                return Optional.of(tmpSong);
        }
        return Optional.ofNullable(null);
    }

    public Song getMostPopularSong(){
        Song song = this.songs.get(0);
        for (Song s : this.songs){
            if(s.popularity() > song.popularity())
                song = s;
        }
        return song;
    }

    public Song getLongestSong(){
        Song song = this.songs.get(0);
        for (Song s : this.songs){
            if(s.length() > song.length())
                song = s;
        }
        return song;
    }

    public static List<Song> readFile(String filename) throws FileNotFoundException {
        List<Song> tmpSongs = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(filename)
        );
        List<String> lines = reader.lines().collect(Collectors.toList());
        for (String line : lines){
            String[] linePieces = line.split(",");
            tmpSongs.add(
                    new Song(
                            linePieces[0] == "" ? -1 : Integer.parseInt(linePieces[0]),
                            linePieces[1],
                            linePieces[2],
                            linePieces[3],
                            linePieces[4] == "" ? -1 : Integer.parseInt(linePieces[4]),
                            linePieces[5] == "" ? -1 : Integer.parseInt(linePieces[5])
                    )
            );
        }

        return tmpSongs;
    }
}

record Song(int id, String name, String author, String genre, int length, int popularity) {

}