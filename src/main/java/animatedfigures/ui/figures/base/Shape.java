package animatedfigures.ui.figures.base;

import animatedfigures.ui.Drawable;

public interface Shape extends Drawable {
    void resize(int factor);

    void move(int xMove, int yMove);
}
