package animatedfigures.ui.shapes;

import animatedfigures.ui.visitor.ShapeVisitor;

public interface Shape {
    void resize(int amount);

    void setSize(int amount);

    void move(int xMove, int yMove);

    int getWidth();

    int getHeight();

    int getX();

    int getY();

    void accept(ShapeVisitor shapeVisitor);
}
