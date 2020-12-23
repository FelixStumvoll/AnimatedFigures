package animatedfigures.ui.shapes.impl;

import animatedfigures.ui.shapes.impl.base.SimpleShapeBase;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;

public class Circle extends SimpleShapeBase {
    private int diameter;

    public Circle(Color color, int x, int y, int diameter, boolean fill) {
        super(color, x, y, fill);
        this.diameter = diameter;
    }

    @Override
    public void resize(int amount) {
        this.diameter += amount;
    }

    @Override
    public void setSize(int amount) {
        this.diameter = amount;
    }

    @Override
    public int getWidth() {
        return this.diameter;
    }

    @Override
    public int getHeight() {
        return this.diameter;
    }

    public int getDiameter() {
        return this.diameter;
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }
}
