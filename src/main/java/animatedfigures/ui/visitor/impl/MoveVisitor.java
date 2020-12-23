package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

public class MoveVisitor implements ShapeVisitor {

    private final int leftBound;
    private final int rightBound;
    private final int acceleration;

    private boolean movesRight = true;

    public MoveVisitor(int leftBound, int rightBound, int acceleration) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.acceleration = acceleration;
    }

    private void moveShape(Shape shape) {
        var move = this.movesRight ? this.acceleration : -this.acceleration;
        shape.move(move, 0);
        if (shape.getX() + shape.getWidth() >= this.rightBound) {
            this.movesRight = false;
        }
        if (shape.getX() <= this.leftBound) {
            this.movesRight = true;
        }
    }

    @Override
    public void visit(ThingA thingA) {
        this.moveShape(thingA);
    }

    @Override
    public void visit(ThingB thingB) {
        this.moveShape(thingB);
    }

    @Override
    public void visit(Circle circle) {
        this.moveShape(circle);
    }

    @Override
    public void visit(Rectangle rectangle) {
        this.moveShape(rectangle);
    }
}
