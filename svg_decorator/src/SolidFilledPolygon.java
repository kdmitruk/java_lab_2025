public class SolidFilledPolygon extends Polygon {
    private String fill;

    public SolidFilledPolygon(Vec2[] points, String fill) {
        super(points);
        this.fill = fill;
    }

    @Override
    public String toSvg() {
        return this.toSvg("");
//      return super.toSvg(String.format("fill=\"%s\" ", fill));
    }

    @Override
    public String toSvg(String param) {
        return super.toSvg(String.format("fill=\"%s\" %s", fill, param));
    }
}
