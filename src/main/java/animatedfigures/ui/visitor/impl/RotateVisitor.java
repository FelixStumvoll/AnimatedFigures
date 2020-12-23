package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class RotateVisitor implements ShapeVisitor {
    @Override
    public void visit(ThingA thingA) {
        var first = thingA.getShapes().get(0);
        var hDistance = first.getX() - thingA.getShapes().get(1).getX();
        var vDistance = first.getY() - thingA.getShapes().get(1).getY();
        var distance = max(abs(hDistance), abs(vDistance));
        for (int i = 1; i < thingA.getShapes().size(); i++) {
            var dist = distance * i;
            var shape = thingA.getShapes().get(i);

            if (hDistance < 0) {
                shape.move(-dist, dist);
            } else if (hDistance > 0) {
                shape.move(dist, -dist);
            } else if (vDistance < 0) {
                shape.move(-dist, -dist);
            } else if (vDistance > 0) {
                shape.move(dist, dist);
            }
        }
    }


    @Override
    public void visit(ThingB thingB) {
        var redX = thingB.getRed().getX();
        var redY = thingB.getRed().getY();

        thingB.getRed().moveTo(thingB.getBlue().getX(), thingB.getBlue().getY());
        thingB.getBlue().moveTo(thingB.getGreen().getX(), thingB.getGreen().getY());
        thingB.getGreen().moveTo(thingB.getYellow().getX(), thingB.getYellow().getY());
        thingB.getYellow().moveTo(redX, redY);
    }

    @Override
    public void visit(Circle circle) {
        //NO OP
    }

    @Override
    public void visit(Rectangle rectangle) {
        var newHeight = rectangle.getWidth();
        var newWidth = rectangle.getHeight();

        rectangle.setHeight(newHeight);
        rectangle.setWidth(newWidth);
    }
}
