package animatedfigures.ui.figures;

import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.base.ShapeGroupBase;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;

public class FigureA extends ShapeGroupBase {
    public FigureA(int x, int y) {
        for (int i = 1; i <= 5; i++) {
            this.getShapes().add(new Circle(Color.GREEN, x + (20 * i), y, 25, i % 2 == 0));
        }
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }
}
