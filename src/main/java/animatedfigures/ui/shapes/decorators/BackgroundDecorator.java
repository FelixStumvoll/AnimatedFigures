package animatedfigures.ui.shapes.decorators;

import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;

public class BackgroundDecorator extends ShapeDecorator {
    private final Color color;

    public BackgroundDecorator(ShapeGroup shapeGroup, Color color) {
        super(shapeGroup);
        this.color = color;
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        new Rectangle(this.color,
                this.shapeGroup.getX() - 5,
                this.shapeGroup.getY() - 5,
                this.shapeGroup.getWidth() + 10,
                this.shapeGroup.getHeight() + 10,
                true).accept(shapeVisitor);
        super.accept(shapeVisitor);
    }
}
