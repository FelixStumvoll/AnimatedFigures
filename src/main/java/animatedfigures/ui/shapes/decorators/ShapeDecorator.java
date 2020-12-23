package animatedfigures.ui.shapes.decorators;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.visitor.ShapeVisitor;

public abstract class ShapeDecorator implements Shape {
    protected final Shape shape;

    protected ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void resize(int amount) {
        this.shape.resize(amount);
    }

    @Override
    public void move(int xMove, int yMove) {
        this.shape.move(xMove, yMove);
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        this.shape.accept(shapeVisitor);
    }

    @Override
    public int getWidth() {
        return this.shape.getWidth();
    }

    @Override
    public int getHeight() {
        return this.shape.getHeight();
    }

    @Override
    public int getX() {
        return this.shape.getX();
    }

    @Override
    public int getY() {
        return this.shape.getY();
    }

    @Override
    public void setSize(int amount) {
        this.shape.setSize(amount);
    }
}
