import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //polygons();
        scene();
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
                new Point(10.0, 10.0),
                new Point(150.0, 10.0),
                new Point(10.0, 150.0)
        };

        Polygon polygon = new Polygon(points);
        System.out.println(polygon);
        System.out.println(polygon.toSvg());
//        points[2] = new Point(2.0, 5.7);
        points[2].setX(5.0);
        points[2].setY(7.4);
        System.out.println(polygon);
        System.out.println(polygon.toSvg());
    }

    public static void scene() throws IOException {
        Polygon p1 = new Polygon(new Point[]{
                new Point(10.0, 10.0),
                new Point(200.0, 10.0),
                new Point(10.0, 200.0)
        }, new Style("green", "yellow", 5.0));
        Polygon p2 = new Polygon(new Point[]{
                new Point(32.0, 53.5),
                new Point(32.0, 50.5),
                new Point(39.0, 55)
        });
        Polygon p3 = new Polygon(new Point[]{
                new Point(4.0, 8.5),
                new Point(10, 20),
                new Point(25, 45)
        });
        Polygon p4 = Polygon.square(
                new Segment(new Point(50, 30), new Point(10, 20)),
                new Style("green", "purple", 1)
        );
        SvgScene scene = new SvgScene();
        scene.addShape(p1);
        scene.addShape(p2);
        scene.addShape(p3);
        scene.addShape(p4);
        scene.addShape(new Ellipse(9, 11, new Point(10, 23)));
        System.out.println(scene);
        //System.out.println(scene.toSvg());
        scene.save("result.svg");

//        Polygon p4 = new Polygon(new Point[]{new Point(2.0, 10.5)});
//        scene.addPolygon(p4);
//        System.out.println(scene);
    }
}
