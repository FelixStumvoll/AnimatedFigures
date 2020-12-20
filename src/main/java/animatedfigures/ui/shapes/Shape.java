package animatedfigures.ui.shapes;

import animatedfigures.ui.Drawable;

public interface Shape extends Drawable {
    void resize(int amount);

    void move(int xMove, int yMove);

    int getWidth();

    int getHeight();

    int getX();

    int getY();

}
