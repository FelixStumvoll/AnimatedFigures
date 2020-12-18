package animatedfigures.ui.figures;

import animatedfigures.core.FigureVisitor;

public class ThingA extends ShapeGroupBase {

    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
