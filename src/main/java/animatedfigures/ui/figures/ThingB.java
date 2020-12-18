package animatedfigures.ui.figures;

import animatedfigures.core.FigureVisitor;
import animatedfigures.ui.shapes.ShapeGroupBase;

public class ThingB extends ShapeGroupBase {
    public ThingB(int x, int y) {
    }

    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
