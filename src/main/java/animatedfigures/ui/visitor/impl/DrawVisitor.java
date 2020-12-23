package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.FigureA;
import animatedfigures.ui.figures.FigureB;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;

public class DrawVisitor implements ShapeVisitor {

    private Graphics g;

    private void visitShapeGroup(ShapeGroup shapeGroup) {
        shapeGroup.getShapes().forEach(s -> s.accept(this));
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
        this.g.setColor(circle.getColor());
        if (circle.isFill()) {
            this.g.fillOval(circle.getX(), circle.getY(), circle.getDiameter(), circle.getDiameter());
        } else {
            this.g.drawOval(circle.getX(), circle.getY(), circle.getDiameter(), circle.getDiameter());
        }
    }

    @Override
    public void visit(Rectangle rectangle) {
        this.g.setColor(rectangle.getColor());
        if (rectangle.isFill()) {
            this.g.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        } else {
            this.g.drawRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        }
    }

    public void setG(Graphics g) {
        this.g = g;
    }
}
