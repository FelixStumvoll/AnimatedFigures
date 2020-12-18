package animatedfigures.ui.figures;

import animatedfigures.ui.figures.base.SimpleShape;

import java.awt.*;

public abstract class SimpleShapeBase implements SimpleShape {
    private Color color;
    private int x;
    private int y;

    public SimpleShapeBase(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int value) {
        this.x = value;
    }

    @Override
    public void setY(int value) {
        this.y = value;
    }
}
