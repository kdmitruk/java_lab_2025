import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private BufferedReader reader;
    private PrintWriter writer;
    private Server server;
    private String login;
    private Socket socket;

    public ClientHandler(Socket socket,Server server) throws IOException {
        InputStream input = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        OutputStream output = socket.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(output),true);
        this.server = server;
        this.socket = socket;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void run() {
        String message;
        try {
            login = reader.readLine();
            server.onClientConnected(this);
            while((message = reader.readLine()) != null) {
                System.out.println(message);
                server.broadcast(message,login);
            }
            socket.close();
            server.onClientDisconnected(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void send(String message) {
        writer.println(message);
    }
}
