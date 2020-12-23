package animatedfigures.ui.visitor;

public interface Visitable {
    void accept(ShapeVisitor shapeVisitor);
}
