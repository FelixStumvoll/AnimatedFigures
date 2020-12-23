package animatedfigures.ui;

import animatedfigures.ui.decorators.BackgroundDecorator;
import animatedfigures.ui.decorators.BorderDecorator;
import animatedfigures.ui.figures.FigureA;
import animatedfigures.ui.figures.FigureB;
import animatedfigures.ui.visitor.impl.FillToggleVisitor;
import animatedfigures.ui.visitor.impl.MoveVisitor;
import animatedfigures.ui.visitor.impl.ResizeVisitor;
import animatedfigures.ui.visitor.impl.RotateVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static animatedfigures.util.ThreadUtil.sleep;

public class MainPanel extends JPanel {

    private final List<AnimatedShape> figures;
    private Thread animationThread;

    public MainPanel(int width, int height) {
        this.setSize(width, height);
        this.figures = List.of(
                new AnimatedShape(
                        new BackgroundDecorator(new FigureA(50, 100), Color.RED),
                        new MoveVisitor(0, 700, 5),
                        new FillToggleVisitor(),
                        new RotateVisitor()
                ),
                new AnimatedShape(
                        new FigureB(400, 250),
                        new RotateVisitor(),
                        new ResizeVisitor(ResizeVisitor::nextIndex, 0, 150, 1, true)
                ),
                new AnimatedShape(
                        new BorderDecorator(new FigureB(100, 250), Color.magenta),
                        new ResizeVisitor(ResizeVisitor::nextIndex, 10, 20, 30, 40),
                        new FillToggleVisitor()));
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.figures.forEach(figure -> figure.draw(g));
    }

    public void startAnimations() {
        this.animationThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                this.figures.forEach(AnimatedShape::animate);
                this.repaint();
                sleep(200);
            }
        });

        this.animationThread.start();
    }

    public void stopAnimations() {
        this.animationThread.interrupt();
    }

}
