public class SolidFillShapeDecorator extends ShapeDecorator {
    private String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }
    public String toSvg()
    {
        return this.toSvg("");
//        return decoratedShape.toSvg();
    }

    @Override
    public String toSvg(String param) {

        return decoratedShape.toSvg(String.format("fill=\"%s\" %s", color, param));
    }
}
