package pl.umcs.dots;

import javafx.scene.paint.Color;

public record Dot(double x, double y, Color color, double radius) {
    public static String toMessage(Dot dot){
        return dot.x + ";" +
                dot.y + ";" +
                dot.color.toString() + ";" +
                dot.radius;
    }
    public static Dot fromMessage(String message){
        String[] parts = message.split(";");
        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
        Color color = Color.web(parts[2]);
        double radius = Double.parseDouble(parts[3]);
        return new Dot(x,y,color,radius);
    }
}
