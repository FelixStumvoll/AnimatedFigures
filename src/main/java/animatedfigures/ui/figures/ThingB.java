package animatedfigures.ui.figures;

import animatedfigures.ui.shapes.Circle;
import animatedfigures.ui.shapes.ShapeGroupBase;
import animatedfigures.ui.visitor.FigureVisitor;

import java.awt.*;

public class ThingB extends ShapeGroupBase {
    public ThingB(int x, int y) {
        var diameter = 20;
        this.getShapes().add(new Circle(Color.RED, x, y, diameter, true));
        this.getShapes().add(new Circle(Color.BLUE, x + 50, y + 50, diameter, true));
        this.getShapes().add(new Circle(Color.GREEN, x, y + 100, diameter, true));
        this.getShapes().add(new Circle(Color.YELLOW, x - 50, y + 50, diameter, true));
    }

    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
