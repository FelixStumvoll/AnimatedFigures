package animatedfigures.ui.shapes.decorators;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;

public class BackgroundDecorator extends ShapeDecorator {
    private final Color color;

    public BackgroundDecorator(Shape shape, Color color) {
        super(shape);
        this.color = color;
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        new Rectangle(this.color,
                this.shape.getX() - 5,
                this.shape.getY() - 5,
                this.shape.getWidth() + 10,
                this.shape.getHeight() + 10,
                true).accept(shapeVisitor);
        super.accept(shapeVisitor);
    }
}
