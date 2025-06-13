package music;

import music_db.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

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

    public static class Persistence {
        public static Optional<Song> read(int id) throws SQLException {
            String sql = "SELECT artist, title, length FROM song WHERE id = ?";
            PreparedStatement statement = DatabaseConnection.getConnection("songs").prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return Optional.of(new Song(
                        resultSet.getString("artist"),
                        resultSet.getString("title"),
                        resultSet.getInt("length")
                ));
            }
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return "Song{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
