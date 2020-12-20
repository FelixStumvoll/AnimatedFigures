package animatedfigures.ui.shapes.base;

import animatedfigures.ui.visitor.Visitable;

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

    @Override
    default int getWidth() {
        return this.getShapes()
                .stream()
                .map(s -> s.getX() + s.getWidth())
                .max(Integer::compare)
                .orElse(0)
                - this.getX();
    }

    @Override
    default int getHeight() {
        return this.getShapes()
                .stream()
                .map(s -> s.getY() + s.getHeight())
                .max(Integer::compare)
                .orElse(0)
                - this.getY();
    }

    @Override
    default int getX() {
        return this.getShapes()
                .stream()
                .map(Shape::getX)
                .min(Integer::compare)
                .orElse(0);
    }

    @Override
    default int getY() {
        return this.getShapes()
                .stream()
                .map(Shape::getY)
                .min(Integer::compare)
                .orElse(0);
    }
}
