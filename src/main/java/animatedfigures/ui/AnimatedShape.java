package animatedfigures.ui;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.visitor.ShapeVisitor;
import animatedfigures.ui.visitor.StatefulVisitor;
import animatedfigures.ui.visitor.impl.DrawVisitor;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AnimatedShape {
    private final Shape shape;
    private final List<ShapeVisitor> shapeVisitors;
    private final DrawVisitor drawVisitor = new DrawVisitor();

    public AnimatedShape(Shape shape, ShapeVisitor... shapeVisitors) {
        this.shape = shape;
        this.shapeVisitors = Arrays.asList(shapeVisitors);
    }

    public void animate() {
        this.shapeVisitors.forEach(v -> {
            this.shape.accept(v);
            if (v instanceof StatefulVisitor) {
                ((StatefulVisitor) v).update();
            }
        });
    }

    public void draw(Graphics g) {
        this.drawVisitor.setG(g);
        this.shape.accept(this.drawVisitor);
    }
}
