package ba.edu.ibu.week10.labs.task4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenreFilterIterator implements Iterator<Song> {
    private Song[] playlist;
    private String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(Song[] playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex+1 <= playlist.length){
            if(playlist[currentIndex].getGenre().equals(targetGenre)) return true;
            else this.currentIndex++;
        }
        return false;
    }

    @Override
    public Song next() {
        if(!this.hasNext()){
            throw new NoSuchElementException("There are no more songs in the list that in the " + this.targetGenre + " genre.");
        } else{
            return playlist[currentIndex++];
        }
    }
}
