package pl.umcs.dots.server;

import javafx.beans.binding.When;
import pl.umcs.dots.Dot;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{
    ServerSocket serverSocket;
    List<ClientThread> clientThreadList = new ArrayList<>();
    DatabaseConnection connection;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);

    }

    @Override
    public void run() {
        connection = new DatabaseConnection();
        try {
            connection.connect("dots.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try {
            persist(Dot.fromMessage(message));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void persist(Dot dot) throws SQLException {
        String sql = "INSERT INTO dot(x, y, color, radius) VALUES (?,?,?,?)";
        PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql);
        statement.setInt(1, (int) dot.x());
        statement.setInt(2, (int) dot.y());
        statement.setString(3, dot.color().toString());
        statement.setInt(4, (int) dot.radius());
        System.out.println(statement.executeUpdate());
    }


}
