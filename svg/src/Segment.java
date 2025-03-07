public class Segment {
    public Point a;
    public Point b;
    public double length(){
        return Math.hypot(a.getX()-b.getX(), a.getY()-b.getY());
    }
}
