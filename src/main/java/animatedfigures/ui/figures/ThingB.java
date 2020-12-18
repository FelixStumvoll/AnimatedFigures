package animatedfigures.ui.figures;

import animatedfigures.core.FigureVisitor;

public class ThingB extends ShapeGroupBase {
    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
