package ba.edu.ibu.week11.lectures.livesessions.firstgroup.problem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        SongSystem ss = new SongSystem("/Users/becir/Documents/Academic Materials/IBU/2024-2025/FALL/Object Oriented Programming/Projects/oop-2024/src/main/java/ba/edu/ibu/week11/lectures/codingproblem/songs.csv");
        Optional<Song> song = ss.getById(50);
        if(song.isPresent())
            System.out.println(song.get());
    }
}

class EmptyFileException extends FileNotFoundException {
    EmptyFileException(String message){
        super(message);
    }
}

class SongSystem {
    List<Song> songs;

    public SongSystem(String filename){
        try {
            this.songs = readSongs(filename);
        } catch (FileNotFoundException e){
            this.songs = new ArrayList<>();
            System.out.println("File is either empty or it does not exists.");
        }
    }

    public static List<Song> readSongs(String filename) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new FileReader(filename)
        );

        List<String> rows = reader.lines().collect(Collectors.toList());

        if(rows.isEmpty())
            throw new EmptyFileException("The file is empty and you are not allowed to use the system");

        List<Song> tmpSongs = new ArrayList<>();

        for (String row : rows) {
            String[] rowParts = row.split(",");
            tmpSongs.add(
                    new Song(
                            rowParts[0] == "" ? 000 : Integer.parseInt(rowParts[0]),
                            rowParts[1],
                            rowParts[2],
                            rowParts[3],
                            rowParts[4] == "" ? 000 : Integer.parseInt(rowParts[4]),
                            rowParts[5] == "" ? 000 : Integer.parseInt(rowParts[5])
                    )
            );
        }

        return tmpSongs;
    }

    public Optional<Song> getById(int id){
        for (Song song : this.songs){
            if(song.id() == id)
                return Optional.of(song);
        }
        return Optional.ofNullable(null);
    }
    public Song getMostPopularSong(){
        Song mostPopularSong = this.songs.get(0);

        for (Song song : this.songs){
            if(song.popularity() > mostPopularSong.popularity())
                mostPopularSong = song;
        }
        return mostPopularSong;
    }
    public Song getShortestSong(){
        Song shortestPopularSong = this.songs.get(0);

        for (Song song : this.songs){
            if(song.length() < shortestPopularSong.length())
                shortestPopularSong = song;
        }
        return shortestPopularSong;
    }
}

record Song(int id, String name, String author, String genre, int length, int popularity){

}
