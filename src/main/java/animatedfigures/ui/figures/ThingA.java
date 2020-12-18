package animatedfigures.ui.figures;

import animatedfigures.core.FigureVisitor;
import animatedfigures.ui.shapes.Circle;
import animatedfigures.ui.shapes.ShapeGroupBase;

import java.awt.*;

public class ThingA extends ShapeGroupBase {

    public ThingA(int x, int y) {
        this.getShapes().add(new Circle(Color.BLACK, x, y, 50));
    }

    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
