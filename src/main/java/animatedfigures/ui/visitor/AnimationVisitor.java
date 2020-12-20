package animatedfigures.ui.visitor;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.base.Shape;
import animatedfigures.ui.shapes.base.ShapeGroup;
import animatedfigures.ui.shapes.base.SimpleShape;
import animatedfigures.util.CastUtil;

public class AnimationVisitor implements FigureVisitor {

    private boolean doesAMoveLeft = false;

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
    public void visit(ThingA thingA) {
        thingA.getShapes().forEach(this::toggleFill);

        var move = this.doesAMoveLeft ? -5 : 5;
        thingA.move(move, 0);

        if (thingA.getX() == 100) this.doesAMoveLeft = true;
        if (thingA.getX() == 10) this.doesAMoveLeft = false;
    }

    private int getXCenter(Shape shape) {
        return shape.getX() + (shape.getWidth() / 2);
    }

    private int getYCenter(Shape shape) {
        return shape.getY() + (shape.getHeight() / 2);
    }

    public void rotate(ShapeGroup shapeGroup, int factor) {
        var centerX = this.getXCenter(shapeGroup);
        var centerY = this.getYCenter(shapeGroup);

        shapeGroup.getShapes()
                .forEach(shape -> {
                    int xMove;
                    int yMove;

                    if (shape.getX() >= centerX) {
                        if (shape.getY() >= centerY) {
                            xMove = -factor;
                        } else {
                            xMove = factor;
                        }
                        yMove = factor;
                    } else {
                        if (shape.getY() >= centerY) {
                            xMove = -factor;
                        } else {
                            xMove = factor;
                        }
                        yMove = -factor;
                    }

                    shape.move(xMove, yMove);
                });
    }

    @Override
    public void visit(ThingB thingB) {
        this.rotate(thingB, 1);
    }
}
