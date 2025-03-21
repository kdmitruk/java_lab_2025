public abstract class Shape {
    final private Style style;
    public abstract String toSvg();
    public abstract BoundingBox boundingBox();

    protected Style getStyle() {
        return style;
    }

    public Shape() {
        this.style = new Style("transparent", "black", 1.0);
    }

    public Shape(Style style) {
        this.style = style;
    }
}
