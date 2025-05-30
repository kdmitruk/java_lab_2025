package music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {

    public Song atSecond (int seconds){

        if (seconds<0) throw new IndexOutOfBoundsException("Sekundy nie mogą być ujemne.");

        int sum = 0;
        for(Song currentSong : this){
            sum += currentSong.getDuration();
            if(sum>seconds) return currentSong;
        }
        throw new IndexOutOfBoundsException("Wykroczenie poza czas playlisty.");

    }
}
