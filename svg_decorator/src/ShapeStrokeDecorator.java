import java.util.Locale;

public class ShapeStrokeDecorator extends ShapeDecorator{
    private String color;
    private double width;

    public ShapeStrokeDecorator(Shape decoratedShape, double width, String color) {
        super(decoratedShape);
        this.width = width;
        this.color = color;
    }
    public String toSvg()
    {
        return this.toSvg("");
//        return decoratedShape.toSvg();
    }

    @Override
    public String toSvg(String param) {

        return decoratedShape.toSvg(String.format(Locale.ENGLISH,"stroke=\"%s\" stroke-width=\"%f\" %s", color,width, param));
    }

    @Override
    public BoundingBox boundingBox() {
        BoundingBox old = decoratedShape.boundingBox();
        return  new BoundingBox(old.x() - width/2, old.y() - width/2, old.width() + width, old.height()+width);
    }
}
