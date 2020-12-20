package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.visitor.ShapeGroupVisitor;

public class MoveVisitor implements ShapeGroupVisitor {

    private final int leftBound;
    private final int rightBound;

    private boolean movesRight = true;

    public MoveVisitor(int leftBound, int rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    @Override
    public void visit(ShapeGroup shapeGroup) {
        var move = this.movesRight ? 5 : -5;
        shapeGroup.move(move, 0);
        if (shapeGroup.getX() >= this.rightBound) {
            this.movesRight = false;
        }
        if (shapeGroup.getX() <= this.leftBound) {
            this.movesRight = true;
        }
    }
}
