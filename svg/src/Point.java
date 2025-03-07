import java.util.Locale;

public class Point {
    private double x;
    private double y;

    public Point() {

    }

    public Point(Point oldP) {
        this.x = oldP.x;
        this.y = oldP.y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

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
