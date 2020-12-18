package animatedfigures.ui.shapes;

import java.awt.*;

public class Rectangle extends SimpleShapeBase {
    private int width;
    private int height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(this.getX(), this.getY(), this.width, this.height);
    }

    @Override
    public void resize(int factor) {
        this.width *= factor;
        this.height *= factor;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
