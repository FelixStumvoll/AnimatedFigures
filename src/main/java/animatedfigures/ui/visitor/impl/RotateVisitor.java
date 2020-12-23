package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.FigureA;
import animatedfigures.ui.figures.FigureB;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class RotateVisitor implements ShapeVisitor {
    @Override
    public void visit(FigureA figureA) {
        var first = figureA.getShapes().get(0);
        var hDistance = first.getX() - figureA.getShapes().get(1).getX();
        var vDistance = first.getY() - figureA.getShapes().get(1).getY();
        var distance = max(abs(hDistance), abs(vDistance));
        for (int i = 1; i < figureA.getShapes().size(); i++) {
            var dist = distance * i;
            var shape = figureA.getShapes().get(i);

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
    public void visit(FigureB figureB) {
        var redX = figureB.getRed().getX();
        var redY = figureB.getRed().getY();
        
        figureB.getRed().moveTo(figureB.getBlue().getX(), figureB.getBlue().getY());
        figureB.getBlue().moveTo(figureB.getGreen().getX(), figureB.getGreen().getY());
        figureB.getGreen().moveTo(figureB.getYellow().getX(), figureB.getYellow().getY());
        figureB.getYellow().moveTo(redX, redY);
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
