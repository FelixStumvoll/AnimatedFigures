package animatedfigures.ui.figures;

import animatedfigures.ui.Drawable;
import animatedfigures.ui.shapes.Circle;
import animatedfigures.ui.shapes.ShapeGroupBase;
import animatedfigures.ui.visitor.FigureVisitor;
import animatedfigures.ui.visitor.Visitable;

import java.awt.*;

public class ThingA extends ShapeGroupBase implements Visitable, Drawable {

    public ThingA(int x, int y) {
        for (int i = 1; i <= 5; i++) {
            this.getShapes().add(new Circle(Color.BLACK, x + (20 * i), y, 25, i % 2 == 0));
        }
    }

    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
