package animatedfigures.ui.visitor;

import animatedfigures.ui.figures.FigureA;
import animatedfigures.ui.figures.FigureB;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;

public interface ShapeVisitor {
    void visit(FigureA figureA);

    void visit(FigureB figureB);

    void visit(Circle circle);

    void visit(Rectangle rectangle);
}
