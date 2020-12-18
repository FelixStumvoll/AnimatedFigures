package animatedfigures.ui.shapes.base;

import animatedfigures.ui.Drawable;

public interface Shape extends Drawable {
    void resize(int factor);

    void move(int xMove, int yMove);

    int getWidth();

    int getHeight();

    int getX();

    int getY();
}
