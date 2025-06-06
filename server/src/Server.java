import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void listen() throws IOException {
        while(true) {
            Socket socket = serverSocket.accept();

            ClientHandler handler = new ClientHandler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}
