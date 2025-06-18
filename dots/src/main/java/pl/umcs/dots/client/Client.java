package pl.umcs.dots.client;

import java.io.*;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread {
    private BufferedReader reader;
    private PrintWriter writer;
    private Consumer<String> onMessageReceived;


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
            while((message = reader.readLine()) != null) {
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
