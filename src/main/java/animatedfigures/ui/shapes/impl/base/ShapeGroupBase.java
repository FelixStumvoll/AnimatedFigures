package animatedfigures.ui.shapes.impl.base;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.ShapeGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class ShapeGroupBase implements ShapeGroup, Shape {
    private final List<Shape> shapes = new ArrayList<>();

    @Override
    public List<Shape> getShapes() {
        return this.shapes;
    }
}
