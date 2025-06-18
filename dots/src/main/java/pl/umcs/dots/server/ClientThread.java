package pl.umcs.dots.server;

import java.io.*;
import java.net.Socket;


class ClientThread extends Thread{

    private BufferedReader reader;
    private PrintWriter writer;
    private Server server;
    private Socket socket;

    public ClientThread(Socket socket, Server server) throws IOException {
        InputStream input = socket.getInputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        OutputStream output = socket.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(output),true);
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        String message;
        try {
            while((message = reader.readLine()) != null) {
                System.out.println(message);
                server.broadcast(message);

            }
            socket.close();
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }

    }

    public void send(String message) {
        writer.println(message);
    }


}