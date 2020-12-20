package animatedfigures.ui.shapes.decorators;

import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.impl.Rectangle;

import java.awt.*;

public class BorderDecorator extends ShapeDecorator {
    private final Color color;

    public BorderDecorator(ShapeGroup shapeGroup, Color color) {
        super(shapeGroup);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        var rect = new Rectangle(this.color,
                this.shapeGroup.getX() - 5,
                this.shapeGroup.getY() - 5,
                this.shapeGroup.getWidth() + 10,
                this.shapeGroup.getHeight() + 10,
                false);

        g.setColor(this.color);
        rect.draw(g);
        super.draw(g);
    }
}
