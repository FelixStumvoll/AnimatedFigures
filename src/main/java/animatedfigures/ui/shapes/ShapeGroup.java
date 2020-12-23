package animatedfigures.ui.shapes;

import java.util.List;

public interface ShapeGroup extends Shape {
    List<Shape> getShapes();
    
    @Override
    default void move(int xMove, int yMove) {
        this.getShapes().forEach(shape -> shape.move(xMove, yMove));
    }

    @Override
    default void resize(int amount) {
        this.getShapes().forEach(shape -> shape.resize(amount));
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

    @Override
    default void setSize(int amount) {
        this.getShapes().forEach(s -> s.setSize(amount));
    }
}
