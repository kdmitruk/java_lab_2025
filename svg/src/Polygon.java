import java.util.Arrays;
import java.util.Locale;

public class Polygon extends Shape {
    private Point[] points;

    private void initPoints(Point[] points) {
        this.points = new Point[points.length];
        for(int i =0; i < points.length; i++)
            this.points[i] = new Point(points[i]);
    }

    public Polygon(Point[] points, Style style) {
        super(style);
        initPoints(points);
    }

    public Polygon(Point[] points) {
        initPoints(points);
    }

//    public Polygon(Point[] points) {
//        this.points = new Point[points.length];
//        for(int i =0; i < points.length; i++)
//        {
//            this.points[i] = new Point(points[i]);
//        }
//    }
//
//    public Polygon(Point[] points, Style style) {
//        this(points);
//        this.style = style;
//    }
    public static Polygon square(Segment segment, Style style) {
        Segment perpendicular = segment.perpendicular();
        Point[] points = new Point[]{segment.getA(), perpendicular.getB(), segment.getB(), perpendicular.getA()};
        return new Polygon(points, style);
    }
    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
    @Override
    public String toSvg()    {
        String pointsString = "";
        for(Point point : points) {
            pointsString += point.getX() + "," + point.getY() + " ";
        }
        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" %s />", pointsString, super.getStyle().toSvg());
    }
    @Override
    public BoundingBox boundingBox() {
        double xMin = this.points[0].getX();
        double xMax = this.points[0].getX();
        double yMin = this.points[0].getY();
        double yMax = this.points[0].getY();

        for (int i = 1; i < points.length; i++) {
            xMin = Math.min(xMin, points[i].getX());
            xMax = Math.max(xMax, points[i].getX());
            yMin = Math.min(yMin, points[i].getY());
            yMax = Math.max(yMax, points[i].getY());
        }
        return new BoundingBox(xMin, yMin, xMax - xMin, yMax - yMin);
    }
}
