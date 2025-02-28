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
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }
    public Point translated(double dx, double dy) {
        Point p = new Point();
        p.x = this.x + dx;
        p.y = this.y + dy;
        return p;
    }
}
