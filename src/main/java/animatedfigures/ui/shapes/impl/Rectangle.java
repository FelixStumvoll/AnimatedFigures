package animatedfigures.ui.shapes.impl;

import animatedfigures.ui.shapes.impl.base.SimpleShapeBase;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;

public class Rectangle extends SimpleShapeBase {
    private int width;
    private int height;

    public Rectangle(Color color, int x, int y, int width, int height, boolean fill) {
        super(color, x, y, fill);
        this.width = width;
        this.height = height;
    }

    @Override
    public void resize(int amount) {
        this.width += amount;
        this.height += amount;
    }

    @Override
    public void setSize(int amount) {
        this.height = amount;
        this.width = amount;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }
}
