package animatedfigures.ui.figures.base;

import animatedfigures.core.Visitable;

import java.awt.*;
import java.util.List;

public interface ShapeGroup extends Shape, Visitable {
    List<Shape> getShapes();

    default void addShape(Shape shape) {
        this.getShapes().add(shape);
    }

    default void removeShape(Shape shape) {
        this.getShapes().remove(shape);
    }

    @Override
    default void move(int xMove, int yMove) {
        this.getShapes().forEach(shape -> shape.move(xMove, yMove));
    }

    @Override
    default void resize(int factor) {
        this.getShapes().forEach(shape -> shape.resize(factor));
    }

    @Override
    default void draw(Graphics g) {
        this.getShapes().forEach(shape -> shape.draw(g));
    }
}
