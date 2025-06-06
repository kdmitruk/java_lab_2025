import java.awt.image.BufferedImage;

public class AddBrightnessWorker implements Runnable {

    private BufferedImage image;
    private int brightnessAmount;
    private int begin;
    private int end;

    public AddBrightnessWorker(BufferedImage image, int brightnessAmount, int begin, int end) {
        this.image = image;
        this.brightnessAmount = brightnessAmount;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {

        for(int y = begin; y<end; y++) {
            for(int x = 0; x<image.getWidth(); x++) {
                int pixel = image.getRGB(x,y);
                int b = pixel & 0x0000ff;
                int g = (pixel & 0x00ff00) >> 8;
                int r = (pixel & 0xff0000) >> 16;
                r = Math.clamp(r+brightnessAmount,0,255);
                g = Math.clamp(g+brightnessAmount,0,255);
                b = Math.clamp(b+brightnessAmount,0,255);
                pixel = b + (g<<8) + (r<<16);
                image.setRGB(x,y,pixel);
            }
        }

    }
}
