import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageProcessor image =new ImageProcessor();
        try {
            {
                image.load("fruits2.png");
                long start = System.currentTimeMillis();
                image.addBrightness(200);
                long end = System.currentTimeMillis();
                System.out.println(end-start);
            }
            {
                image.load("fruits2.png");
                long start = System.currentTimeMillis();
                image.addBrightnessThreaded(200);
                long end = System.currentTimeMillis();
                System.out.println(end-start);
            }
            {
                image.load("fruits2.png");
                long start = System.currentTimeMillis();
                image.addBrightnessThreadPooled(200);
                long end = System.currentTimeMillis();
                System.out.println(end-start);
                image.save("out2.jpg");
            }
//            image.save("out.jpg");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
