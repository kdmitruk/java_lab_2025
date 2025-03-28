public interface Shape {
    BoundingBox boundingBox();
    String toSvg();
    String toSvg(String param);
}
