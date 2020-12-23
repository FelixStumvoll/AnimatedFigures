package animatedfigures.ui.visitor;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;

public interface ShapeVisitor {
    void visit(ThingA thingA);

    void visit(ThingB thingB);

    void visit(Circle circle);

    void visit(Rectangle rectangle);
}
