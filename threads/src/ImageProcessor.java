import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ImageProcessor {
    private BufferedImage image;

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

    public void addBrightnessThreaded(int amount) throws InterruptedException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < coreCount; i++) {
            AddBrightnessWorker worker = new AddBrightnessWorker(image,amount,(image.getHeight()/coreCount)*i,(image.getHeight()/coreCount)*(i+1));
            Thread thread = new Thread(worker);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread:threads){
            thread.join();
        }
    }

    public void addBrightnessThreadPooled(int amount) throws InterruptedException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        for(int y=0; y<image.getHeight(); y++){
            int finalY = y;
            service.execute(()->{
                for(int x = 0; x<image.getWidth(); x++) {
                    int pixel = image.getRGB(x, finalY);
                    int b = pixel & 0x0000ff;
                    int g = (pixel & 0x00ff00) >> 8;
                    int r = (pixel & 0xff0000) >> 16;
                    r = Math.clamp(r+amount,0,255);
                    g = Math.clamp(g+amount,0,255);
                    b = Math.clamp(b+amount,0,255);
                    pixel = b + (g<<8) + (r<<16);
                    image.setRGB(x, finalY,pixel);
                }
            });
        }
        service.shutdown();
        service.awaitTermination(2, TimeUnit.SECONDS);
    }
}
