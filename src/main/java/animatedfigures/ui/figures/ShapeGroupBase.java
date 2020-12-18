package animatedfigures.ui.figures;

import animatedfigures.ui.figures.base.Shape;
import animatedfigures.ui.figures.base.ShapeGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class ShapeGroupBase implements ShapeGroup {
    private final List<Shape> shapes = new ArrayList<>();

    @Override
    public List<Shape> getShapes() {
        return this.shapes;
    }
}
