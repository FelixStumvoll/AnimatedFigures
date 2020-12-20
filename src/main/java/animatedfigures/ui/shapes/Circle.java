package animatedfigures.ui.shapes;

import java.awt.*;

public class Circle extends SimpleShapeBase {
    private int diameter;

    public Circle(Color color, int x, int y, int diameter, boolean fill) {
        super(color, x, y, fill);
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        if (this.isFill()) {
            g.fillOval(this.getX(), this.getY(), this.diameter, this.diameter);
        } else {
            g.drawOval(this.getX(), this.getY(), this.diameter, this.diameter);
        }

    }

    @Override
    public void resize(int factor) {
        this.diameter *= factor;
    }

    @Override
    public int getWidth() {
        return this.diameter;
    }

    @Override
    public int getHeight() {
        return this.diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
