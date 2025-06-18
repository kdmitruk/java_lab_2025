package pl.umcs.dots;

import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.umcs.dots.client.Client;
import pl.umcs.dots.server.Server;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField addressField, portField;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Slider radiusSlider;

    @FXML
    private Canvas canvas;

    private Server server;
    private Client client;

    @FXML
    private void onStartServerClicked() throws IOException {
        int port = Integer.parseInt(portField.getText());
        server = new Server(port);
        server.start();
        initializeClient("localhost");
    }

    @FXML
    private void onConnectClicked() throws IOException {
        String address = addressField.getText();
        initializeClient(address);
    }

    private void initializeClient(String adress) throws IOException {
        int port = Integer.parseInt(portField.getText());
        client = new Client();
        client.connect(adress,port);
        client.setOnMessageReceived(message->drawCircle(Dot.fromMessage(message)));
        client.start();
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX());
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        Color color = colorPicker.getValue();
        double radius = radiusSlider.getValue();
        client.send(Dot.toMessage(new Dot(x,y,color,radius)));
//        drawCircle(x,y,color,radius);
//        String message = Dot.toMessage(new Dot(x,y,color,radius));
//        Dot dot = Dot.fromMessage(message);
//        System.out.println(dot);
    }

    public void drawCircle(Dot dot){
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(dot.color());
        context.fillOval(dot.x()-dot.radius(), dot.y()-dot.radius(), dot.radius()*2, dot.radius()*2);
    }
}