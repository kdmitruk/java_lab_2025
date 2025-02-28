import java.util.Locale;

public class Point {
    public double x;
    public double y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public String toSvg()
    {
        return String.format(Locale.ENGLISH,"<circle r=\"5\" cx=\"%f\" cy=\"%f\" fill=\"red\" />", x, y);
    }
//    public String toString() {
//        return "X = " + x + "\nY = " + y;
//    }
}
