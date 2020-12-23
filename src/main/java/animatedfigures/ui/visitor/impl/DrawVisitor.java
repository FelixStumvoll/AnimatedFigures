package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;

public class DrawVisitor implements ShapeVisitor {

    private final Graphics g;

    public DrawVisitor(Graphics g) {
        this.g = g;
    }


    private void visitShapeGroup(ShapeGroup shapeGroup) {
        shapeGroup.getShapes().forEach(s -> s.accept(this));
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
}
