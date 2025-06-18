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

public class HelloController {
    @FXML
    private TextField addressField, portField;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Slider radiusSlider;

    @FXML
    private Canvas canvas;

    @FXML
    private void onStartServerClicked() {

    }

    @FXML
    private void onConnectClicked() {

    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX());
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        Color color = colorPicker.getValue();
        double radius = radiusSlider.getValue();
        drawCircle(x,y,color,radius);
    }

    public void drawCircle(double x, double y, Color color, double radius){
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(color);
        context.fillOval(x-radius, y-radius, radius*2, radius*2);
    }
}