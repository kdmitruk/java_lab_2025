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

    public double length(){
        return Math.hypot(a.getX()-b.getX(), a.getY()-b.getY());
    }
}
