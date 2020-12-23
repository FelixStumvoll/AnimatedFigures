package animatedfigures.ui.figures;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.base.ShapeGroupBase;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;
import java.util.List;

public class ThingB extends ShapeGroupBase {

    private final Circle red;
    private final Circle blue;
    private final Circle green;
    private final Circle yellow;

    @Override
    public List<Shape> getShapes() {
        return List.of(this.red, this.blue, this.green, this.yellow);
    }

    public ThingB(int x, int y) {
        var diameter = 20;
        this.red = new Circle(Color.RED, x, y, diameter, true);
        this.blue = new Circle(Color.BLUE, x + 50, y + 50, diameter, true);
        this.green = new Circle(Color.GREEN, x, y + 100, diameter, true);
        this.yellow = new Circle(Color.YELLOW, x - 50, y + 50, diameter, true);
    }

    public Circle getRed() {
        return this.red;
    }

    public Circle getBlue() {
        return this.blue;
    }

    public Circle getGreen() {
        return this.green;
    }

    public Circle getYellow() {
        return this.yellow;
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }
}
