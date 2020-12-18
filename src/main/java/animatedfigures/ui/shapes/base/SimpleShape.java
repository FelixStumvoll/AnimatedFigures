package animatedfigures.ui.shapes.base;

import java.awt.*;

public interface SimpleShape extends Shape {
    void setColor(Color color);

    Color getColor();

    @Override
    default void move(int xMove, int yMove) {
        this.setX(this.getX() + xMove);
        this.setY(this.getY() + yMove);
    }

    void setX(int value);

    void setY(int value);
}