import music.Song;
import music_db.Account;
import music_db.DatabaseConnection;

import javax.naming.AuthenticationException;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws AuthenticationException, SQLException {
        DatabaseConnection.connect("account.db");
        Account.Persistence.init();

        Account.Persistence.register("bob", "secret");
        System.out.println(Account.Persistence.authenticate("bob", "secret"));

        DatabaseConnection.connect("songs.db", "songs");
        Optional<Song> song = Song.Persistence.read(1);
        System.out.println(song.get());



    }
}
