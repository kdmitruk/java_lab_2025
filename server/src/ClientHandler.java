import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private BufferedReader reader;
    private PrintWriter writer;
    private Server server;

    public ClientHandler(Socket socket,Server server) throws IOException {
        InputStream input = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        OutputStream output = socket.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(output),true);
        this.server = server;
    }

    @Override
    public void run() {
        String message;
        try {
            while((message = reader.readLine()) != null) {
                System.out.println(message);
                server.broadcast(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void send(String message) {
        writer.println(message);
    }
}
