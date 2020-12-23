package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.SimpleShape;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

public class FillFlipVisitor implements ShapeVisitor {

    private void visitShapeGroup(ShapeGroup shapeGroup) {
        shapeGroup.getShapes().forEach(s -> s.accept(this));
    }

    private void visitSimpleShape(SimpleShape shape) {
        shape.setFill(!shape.isFill());
    }

    @Override
    public void visit(ThingA thingA) {
        this.visitShapeGroup(thingA);
    }

    @Override
    public void visit(ThingB thingB) {
        this.visitShapeGroup(thingB);
    }

    @Override
    public void visit(Circle circle) {
        this.visitSimpleShape(circle);
    }

    @Override
    public void visit(Rectangle rectangle) {
        this.visitSimpleShape(rectangle);
    }
}
