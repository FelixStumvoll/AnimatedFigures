package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.FigureA;
import animatedfigures.ui.figures.FigureB;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.SimpleShape;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

public class FillToggleVisitor implements ShapeVisitor {

    private void visitShapeGroup(ShapeGroup shapeGroup) {
        shapeGroup.getShapes().forEach(s -> s.accept(this));
    }

    private void visitSimpleShape(SimpleShape shape) {
        shape.setFill(!shape.isFill());
    }

    @Override
    public void visit(FigureA figureA) {
        this.visitShapeGroup(figureA);
    }

    @Override
    public void visit(FigureB figureB) {
        this.visitShapeGroup(figureB);
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
