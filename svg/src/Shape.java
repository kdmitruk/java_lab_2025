public abstract class Shape {
    protected Style style = new Style("transparent", "black", 1.0);
    public abstract String toSvg();
    public abstract BoundingBox boundingBox();
}
