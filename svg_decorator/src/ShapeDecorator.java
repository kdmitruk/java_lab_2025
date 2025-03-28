public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public BoundingBox boundingBox() {
        return decoratedShape.boundingBox();
    }

    @Override
    public String toSvg() {
        return this.toSvg("");
//        return decoratedShape.toSvg();
    }

    @Override
    public String toSvg(String param) {
        return decoratedShape.toSvg(param);
    }
}
