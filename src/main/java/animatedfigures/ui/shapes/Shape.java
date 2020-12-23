package animatedfigures.ui.shapes;

import animatedfigures.ui.visitor.Visitable;

public interface Shape extends Visitable {
    void resize(int amount);

    void setSize(int amount);

    void move(int xMove, int yMove);
    
    int getWidth();

    int getHeight();

    int getX();

    int getY();

}
