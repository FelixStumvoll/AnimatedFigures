package animatedfigures.ui.visitor;

import animatedfigures.ui.shapes.ShapeGroup;

public interface ShapeGroupVisitor {
    void visit(ShapeGroup shapeGroup);
}
