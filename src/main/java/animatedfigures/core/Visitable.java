package animatedfigures.core;

public interface Visitable {
    void accept(FigureVisitor figureVisitor);
}
