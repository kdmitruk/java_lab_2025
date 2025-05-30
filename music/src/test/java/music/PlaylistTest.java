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

    @Test
    public void containsEqualElement() {
        Playlist playlist = new Playlist();
        Song piosenka = new Song("Eminem", "The Real Slim Shady", 200);
        playlist.add(piosenka);
        Song piosenka2 = new Song("Eminem", "The Real Slim Shady", 200);
        assertEquals(piosenka2,playlist.getFirst());
    }

    @Test
    public void testAtSecond(){
        Playlist playlist = new Playlist();
        Song piosenka = new Song("Eminem", "The Real Slim Shady", 200);
        playlist.add(piosenka);
        Song piosenka2 = new Song("Fimiguerrero", "Tartan", 150);
        playlist.add(piosenka2);
        assertEquals(piosenka, playlist.atSecond(100));
    }

    public IndexOutOfBoundsException testAtSecondThrowsExceptionCommon(int second) {
        Playlist playlist = new Playlist();
        Song piosenka = new Song("Eminem", "The Real Slim Shady", 200);
        playlist.add(piosenka);
        Song piosenka2 = new Song("Fimiguerrero", "Tartan", 150);
        playlist.add(piosenka2);

        return assertThrows(IndexOutOfBoundsException.class, () -> playlist.atSecond(second));
    }

    @Test
    public void testAtSecondThrowsException() {
        IndexOutOfBoundsException exception = testAtSecondThrowsExceptionCommon(2134215);
        assertEquals("Wykroczenie poza czas playlisty.",exception.getMessage());
    }

    @Test
    public void testAtSecondThrowsExceptionForNegativeSeconds() {
        IndexOutOfBoundsException exception = testAtSecondThrowsExceptionCommon(-21);
        assertEquals("Sekundy nie mogą być ujemne.",exception.getMessage());
    }
}
