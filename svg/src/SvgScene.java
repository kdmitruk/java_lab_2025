import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class SvgScene {
    /*private int indexP = 0;
    private Polygon[] polygons = new Polygon[3];
    private int indexE = 0;
    private Ellipse[] ellipses = new Ellipse[3];*/
    private final int size = 10;
    private Shape[] shapes = new Shape[size];
    private int index=0;

    public void addShape(Shape shape){
        shapes[(index++)%size] = shape;
    }

    private BoundingBox sceneBox() {
        double maxX = 0, maxY = 0;
        for(Shape shape: shapes) {
            if(shape != null) {
                BoundingBox polygonBB = shape.boundingBox();
                maxX = Math.max(maxX, polygonBB.x() + polygonBB.width());
                maxY = Math.max(maxY, polygonBB.y() + polygonBB.height());
            }
        }
        return new BoundingBox(0, 0, maxX, maxY);
    }

    public String toSvg()
    {
        BoundingBox boundingBox = this.sceneBox();
        String result = String.format(Locale.ENGLISH,
                "<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">",
                boundingBox.width(), boundingBox.height());
        for(var shape : shapes)
        {
            if(shape != null)
                result += "\n\t" + shape.toSvg();
        }
        result += "\n</svg>";
        return result;
    }

    public void save(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(toSvg());
        writer.close();
    }




}
