import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class PlantUMLRunner {
    private static String jarPath;
    public static void setJarPath(String path){
        jarPath = path;
    }
    public static void generate(String data, String outputPath, String fileName){
        File directory = new File(outputPath);
        directory.mkdirs();
        File file = new File(outputPath + "/" + fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
