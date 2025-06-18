package pl.umcs.dots.server;

import javafx.beans.binding.When;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{
    ServerSocket serverSocket;
    List<ClientThread> clientThreadList = new ArrayList<>();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);

    }

    @Override
    public void run() {
        while (true){
            try {
                Socket socket = serverSocket.accept();
                ClientThread thread =new ClientThread(socket,this);
                clientThreadList.add(thread);
                thread.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public void broadcast(String message) {
        for(ClientThread handler : clientThreadList) {
            handler.send(message);
        }
    }


}
