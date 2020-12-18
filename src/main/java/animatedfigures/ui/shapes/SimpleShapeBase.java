package animatedfigures.ui.shapes;

import animatedfigures.ui.shapes.base.Shape;
import animatedfigures.ui.shapes.base.SimpleShape;

import java.awt.*;

public abstract class SimpleShapeBase implements SimpleShape, Shape {
    private Color color;
    private int x;
    private int y;

    public SimpleShapeBase(Color color, int x, int y) {
        this.color = color;
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
