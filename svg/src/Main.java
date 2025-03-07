public class Main {
    public static void main(String[] args) {

        polygons();
    }
    public static void oldCode() {
            //        Point p = new Point();
//        p.setX(5.0);
//        p.setY(7.5);

            Point p = new Point(5.0, 7.5);

//        System.out.println("X = " + p.x + " Y = " + p.y);
            //System.out.println(p);
            //System.out.println(p.toSvg());

            Point p2 = p.translated(4.0, 3.0);
            System.out.println(p);
            System.out.println(p2);
            Segment s1=new Segment(p, p2);
            System.out.println(s1);
            p.setX(100.0);
            System.out.println(s1);
            System.out.println(s1.length());
            Segment s2 = new Segment(new Point(3.5, 5.3), new Point(4.2, 2.4));
            System.out.println(s2);
    }

    public static void polygons() {
        Point[] points = {
                new Point(10.0, 50.0),
                new Point(50.0, 100.0),
                new Point(100.0, 150.0)
        };

        Polygon polygon = new Polygon(points);
        System.out.println(polygon);
        System.out.println(polygon.toSvg());
    }
}
