import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    BufferedImage image;

    public void load(String path) throws IOException {
        File file= new File(path);
        image = ImageIO.read(file);
    }
    public void save(String path) throws IOException {
        ImageIO.write(image,"jpg" ,new File(path));
    }

    public void addBrightness(int amount) {

        for(int y = 0; y<image.getHeight(); y++) {
            for(int x = 0; x<image.getWidth(); x++) {
                int pixel = image.getRGB(x,y);
                //System.out.println(Integer.toHexString(pixel));
                int b = pixel & 0x0000ff;
                //System.out.println(b);
                int g = (pixel & 0x00ff00) >> 8;
                //System.out.println(Integer.toHexString(g));
                int r = (pixel & 0xff0000) >> 16;
                //System.out.println(Integer.toHexString(r));


                r = Math.clamp(r+amount,0,255);
                g = Math.clamp(g+amount,0,255);
                b = Math.clamp(b+amount,0,255);

                pixel = b + (g<<8) + (r<<16);
                image.setRGB(x,y,pixel);
            }
        }
    }
}
