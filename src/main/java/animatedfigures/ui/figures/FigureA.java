package animatedfigures.ui.figures;

import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.visitor.ShapeVisitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FigureA implements ShapeGroup {
    private final List<Shape> shapes = new ArrayList<>();

    public FigureA(int x, int y) {
        for (int i = 1; i <= 5; i++) {
            this.shapes.add(new Circle(Color.GREEN, x + (20 * i), y, 25, i % 2 == 0));
        }
    }

    @Override
    public List<Shape> getShapes() {
        return Collections.unmodifiableList(this.shapes);
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visit(this);
    }


}
