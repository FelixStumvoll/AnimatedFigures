package animatedfigures.ui.shapes;

import java.awt.*;

public class Circle extends SimpleShapeBase {
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(this.getX(), this.getY(), this.radius / 2, this.radius / 2); //TODO maybe center
    }

    @Override
    public void resize(int factor) {
        this.radius *= factor;
    }

    @Override
    public int getWidth() {
        return this.radius * 2;
    }

    @Override
    public int getHeight() {
        return this.radius * 2;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
