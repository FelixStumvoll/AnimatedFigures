package animatedfigures.ui.shapes.decorators;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.visitor.ShapeGroupVisitor;

import java.awt.*;
import java.util.List;

public abstract class ShapeDecorator implements ShapeGroup {
    protected final ShapeGroup shapeGroup;

    protected ShapeDecorator(ShapeGroup shapeGroup) {
        this.shapeGroup = shapeGroup;
    }

    @Override
    public List<Shape> getShapes() {
        return this.shapeGroup.getShapes();
    }

    @Override
    public void addShape(Shape shape) {
        this.shapeGroup.addShape(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        this.shapeGroup.removeShape(shape);
    }

    @Override
    public void draw(Graphics g) {
        this.shapeGroup.draw(g);
    }

    @Override
    public void resize(int amount) {
        this.shapeGroup.resize(amount);
    }

    @Override
    public void move(int xMove, int yMove) {
        this.shapeGroup.move(xMove, yMove);
    }

    @Override
    public void accept(ShapeGroupVisitor shapeGroupVisitor) {
        this.shapeGroup.accept(shapeGroupVisitor);
    }

    @Override
    public int getWidth() {
        return this.shapeGroup.getWidth();
    }

    @Override
    public int getHeight() {
        return this.shapeGroup.getHeight();
    }

    @Override
    public int getX() {
        return this.shapeGroup.getX();
    }

    @Override
    public int getY() {
        return this.shapeGroup.getY();
    }
}
