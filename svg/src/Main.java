public class Main {
    public static void main(String[] args) {
        Point p = new Point();
        p.x = 5.0;
        p.y = 7.5;

//        System.out.println("X = " + p.x + " Y = " + p.y);
        //System.out.println(p);
        //System.out.println(p.toSvg());

        Point p2 = p.translated(2.0, 3.5);
        System.out.println(p);
        System.out.println(p2);
    }
}
