package animatedfigures.ui.shapes.impl;

import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.visitor.ShapeVisitor;
import animatedfigures.ui.visitor.impl.DrawVisitor;
import animatedfigures.ui.visitor.impl.ResizeVisitor;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AnimatedShapeGroup {
    private final ShapeGroup shapeGroup;
    private final List<ShapeVisitor> shapeVisitors;

    public AnimatedShapeGroup(ShapeGroup shapeGroup, ShapeVisitor... shapeVisitors) {
        this.shapeGroup = shapeGroup;
        this.shapeVisitors = Arrays.asList(shapeVisitors);
    }

    public void animate() {
        this.shapeVisitors.forEach(v -> {
            this.shapeGroup.accept(v);
            if (v instanceof ResizeVisitor) {
                ((ResizeVisitor) v).update(ResizeVisitor::nextIndex);
            }
        });
    }

    public void draw(Graphics g) {
        this.shapeGroup.accept(new DrawVisitor(g));
    }
}
