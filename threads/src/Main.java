import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageProcessor image =new ImageProcessor();
        try {
            image.load("fruits.png");
            image.addBrightness(-100);
            image.save("out.jpg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
