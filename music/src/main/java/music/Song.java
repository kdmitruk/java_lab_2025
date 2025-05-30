package music;

//public record Song(String artist, String title, int duration) {
//}
public class Song {
    private final String artist;
    private final String title;
    private final int duration;

    public Song(String artist, String title, int duration) {
        this.artist = artist;
        this.duration = duration;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Song)) return false;
        Song song = (Song) obj;
        return this.artist.equals(song.artist)
                && this.title.equals(song.title)
                && this.duration == song.duration;
    }
}
