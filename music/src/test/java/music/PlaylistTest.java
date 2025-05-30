package music;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    @Test
    public void testEmptyPlaylist() {
        Playlist playlist = new Playlist();
        assertTrue(playlist.isEmpty());
    }

    @Test
    public void addSingleSongTest() {
        Playlist playlist = new Playlist();
        playlist.add(new Song("Eminem","The Real Slim Shady",200));
        assertEquals(1,playlist.size());
    }

    @Test
    public void checkSameElement(){
        Playlist playlist = new Playlist();
        Song piosenka = new Song("Eminem", "The Real Slim Shady", 200);
        playlist.add(piosenka);
        assertEquals(piosenka, playlist.getFirst());
    }
}
