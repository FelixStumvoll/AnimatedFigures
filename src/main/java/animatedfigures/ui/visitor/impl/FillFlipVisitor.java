package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.SimpleShape;
import animatedfigures.ui.visitor.ShapeGroupVisitor;
import animatedfigures.util.CastUtil;

public class FillFlipVisitor implements ShapeGroupVisitor {
    private void toggleFill(Shape shape) {
        if (shape instanceof SimpleShape) {
            var simpleShape = CastUtil.<SimpleShape>cast(shape);
            simpleShape.setFill(!simpleShape.isFill());
        } else if (shape instanceof ShapeGroup) {
            var shapeGroup = CastUtil.<ShapeGroup>cast(shape);
            shapeGroup.getShapes().forEach(this::toggleFill);
        }
    }

    @Override
    public void visit(ShapeGroup shapeGroup) {
        shapeGroup.getShapes().forEach(this::toggleFill);
    }
}
