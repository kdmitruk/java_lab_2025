public class Segment {
    private Point a;
    private Point b;

    public Segment(Point a, Point b) {
        this.a = new Point(a);
        this.b = new Point(b);
    }

    @Override
    public String toString() {
        return "Segment{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }
    public Segment perpendicular(){
        Point center = new Point((a.getX() + b.getX())/2, (a.getY()+b.getY())/2);
        double halfX = (a.getX() - b.getX())/2;
        double halfY = (a.getY() - b.getY())/2;
        Point ap = new Point(center.getX() - halfY, center.getY() + halfX);
        Point bp = new Point(center.getX() + halfY, center.getY() - halfX);
        return new Segment(ap, bp);
    }
    public double length(){
        return Math.hypot(a.getX()-b.getX(), a.getY()-b.getY());
    }
}
