package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.visitor.ShapeGroupVisitor;

public class ResizeVisitor implements ShapeGroupVisitor {

    private final int lowerBound;
    private final int upperBound;
    private final int factor;
    private boolean grows = true;

    public ResizeVisitor(int lowerBound, int upperBound, int factor) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.factor = factor;
    }

    @Override
    public void visit(ShapeGroup shapeGroup) {
        var growFactor = this.grows ? this.factor : -this.factor;
        shapeGroup.resize(growFactor);
        if (shapeGroup.getShapes().stream().map(Shape::getWidth).allMatch(w -> w >= this.upperBound)) {
            this.grows = false;
        }
        if (shapeGroup.getShapes().stream().map(Shape::getWidth).allMatch(w -> w <= this.lowerBound)) {
            this.grows = true;
        }
    }
}
