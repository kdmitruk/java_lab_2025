package pl.umcs.gui_client;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Client implements Runnable {
    private BufferedReader reader;
    private PrintWriter writer;
    private Consumer<String> onMessageReceived;

    private Consumer<String> onAddUser;
    private Consumer<String> onRemoveUser;
    private Consumer<List<String>> onLoadUsers;

    public void setOnAddUser(Consumer<String> onAddUser) {
        this.onAddUser = onAddUser;
    }

    public void setOnRemoveUser(Consumer<String> onRemoveUser) {
        this.onRemoveUser = onRemoveUser;
    }

    public void setOnLoadUsers(Consumer<List<String>> onLoadUsers) {
        this.onLoadUsers = onLoadUsers;
    }

    public void setOnMessageReceived(Consumer<String> onMessageReceived) {
        this.onMessageReceived = onMessageReceived;
    }

    public void connect(String address, int port) throws IOException {
        Socket socket = new Socket(address, port);
        InputStream input = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        OutputStream output = socket.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(output),true);

    }

    @Override
    public void run() {
        String message;
        try {
            //login = reader.readLine();
            while((message = reader.readLine()) != null) {
                if(message.startsWith("$")) {
                    message = message.substring(1);
                    if(message.startsWith("login") || message.startsWith("logout") || message.startsWith("online") ) {
                        String[] parts = message.split("\\$");
                        switch(parts[0]) {
                            case "login" -> onAddUser.accept(parts[1]);
                            case "logout" -> onRemoveUser.accept(parts[1]);
                            case "online" -> onLoadUsers.accept(List.of(parts).subList(1, parts.length - 1));
                        }


                    }
                }
                else
                    onMessageReceived.accept(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String message){
        writer.println(message);
    }
}

