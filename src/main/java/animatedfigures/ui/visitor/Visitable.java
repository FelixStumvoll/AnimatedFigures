package animatedfigures.ui.visitor;

public interface Visitable {
    void accept(ShapeGroupVisitor shapeGroupVisitor);
}
