import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    ServerSocket serverSocket;
    List<ClientHandler> clientHandlers;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientHandlers = new ArrayList<>();
    }

    public void listen() throws IOException {
        while(true) {
            Socket socket = serverSocket.accept();

            ClientHandler handler = new ClientHandler(socket,this);
            clientHandlers.add(handler);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }

    public void broadcast(String message) {
        for(ClientHandler handler : clientHandlers) {
            handler.send(message);
        }
    }
}
