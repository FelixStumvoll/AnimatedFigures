package animatedfigures.ui.shapes.decorators;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.visitor.ShapeVisitor;

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
    public void resize(int amount) {
        this.shapeGroup.resize(amount);
    }

    @Override
    public void move(int xMove, int yMove) {
        this.shapeGroup.move(xMove, yMove);
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        this.shapeGroup.accept(shapeVisitor);
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
