package music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {

    public Song atSecond (int seconds){
//        int sum = 0;
//        for(Song currentSong : this){
//            sum += currentSong.getDuration();
//            if(sum>seconds) return currentSong;
//        }
//        return null;
        int sum = 0;
        for(Song currentSong : this){
            sum += currentSong.getDuration();
            if(sum>seconds) return currentSong;
        }
        throw new IndexOutOfBoundsException();

    }
}
