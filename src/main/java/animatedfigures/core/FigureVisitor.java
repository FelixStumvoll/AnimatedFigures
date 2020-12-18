package animatedfigures.core;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;

public interface FigureVisitor {
    void visit(ThingA thingA);

    void visit(ThingB thingB);
}
