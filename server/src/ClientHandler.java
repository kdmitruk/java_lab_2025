import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private BufferedReader reader;

    public ClientHandler(Socket socket) throws IOException {
        InputStream input = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(input));

    }

    @Override
    public void run() {
        String message;
        try {
            while((message = reader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
