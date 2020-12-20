package animatedfigures.ui.shapes.impl;

import animatedfigures.ui.Drawable;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.visitor.ShapeGroupVisitor;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AnimatedShapeGroup implements Drawable {
    private final ShapeGroup shapeGroup;
    private final List<ShapeGroupVisitor> shapeGroupVisitors;

    public AnimatedShapeGroup(ShapeGroup shapeGroup, ShapeGroupVisitor... shapeGroupVisitors) {
        this.shapeGroup = shapeGroup;
        this.shapeGroupVisitors = Arrays.asList(shapeGroupVisitors);
    }

    public void animate() {
        this.shapeGroupVisitors.forEach(v -> v.visit(this.shapeGroup));
    }

    @Override
    public void draw(Graphics g) {
        this.shapeGroup.draw(g);
    }
}
