package animatedfigures.ui.visitor.impl;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.Shape;
import animatedfigures.ui.shapes.ShapeGroup;
import animatedfigures.ui.shapes.SimpleShape;
import animatedfigures.ui.shapes.impl.Circle;
import animatedfigures.ui.shapes.impl.Rectangle;
import animatedfigures.ui.visitor.ShapeVisitor;
import animatedfigures.ui.visitor.StatefulVisitor;

import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResizeVisitor implements ShapeVisitor, StatefulVisitor<ResizeVisitor> {

    private final int[] steps;
    private int currentIndex = 0;

    public ResizeVisitor(int... steps) {
        this.steps = steps;
    }

    private IntStream getStream(int lower, int upper, int stepSize) {
        return IntStream.range(lower, upper).filter(x -> x % stepSize == 0);
    }

    public ResizeVisitor(int lower, int upper, int stepSize, boolean bidirectionalResizing) {
        if (bidirectionalResizing) {
            this.steps = Stream.concat(
                    this.getStream(lower, upper, stepSize).boxed(),
                    this.getStream(lower + 1, upper, stepSize).boxed().sorted(Collections.reverseOrder()))
                    .mapToInt(value -> value)
                    .toArray();
        } else {
            this.steps = this.getStream(lower, upper, stepSize).toArray();
        }
    }

    private void visitShapeGroup(ShapeGroup shapeGroup) {
        this.resizeShape(shapeGroup);
    }

    private void visitSimpleShape(SimpleShape shape) {
        this.resizeShape(shape);
    }

    private void resizeShape(Shape shape) {
        shape.setSize(this.steps[this.currentIndex]);
    }

    @Override
    public void visit(ThingA thingA) {
        this.visitShapeGroup(thingA);
    }

    @Override
    public void visit(ThingB thingB) {
        this.visitShapeGroup(thingB);
    }

    @Override
    public void visit(Circle circle) {
        this.visitSimpleShape(circle);
    }

    @Override
    public void visit(Rectangle rectangle) {
        this.visitSimpleShape(rectangle);
    }

    public void nextIndex() {
        this.currentIndex = (this.currentIndex + 1) % this.steps.length;
    }

    @Override
    public void update(Consumer<ResizeVisitor> consumer) {
        consumer.accept(this);
    }
}
