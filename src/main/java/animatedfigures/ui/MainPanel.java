package animatedfigures.ui;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.base.ShapeGroup;
import animatedfigures.ui.shapes.decorators.BackgroundDecorator;
import animatedfigures.ui.shapes.decorators.BorderDecorator;
import animatedfigures.ui.visitor.AnimationVisitor;
import animatedfigures.ui.visitor.FigureVisitor;
import animatedfigures.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static animatedfigures.util.ThreadUtil.sleep;

public class MainPanel extends JPanel implements Drawable {

    private final List<ShapeGroup> figures = new ArrayList<>();
    FigureVisitor animator = new AnimationVisitor();
    private Thread animationThread;

    public MainPanel(Pair<Integer, Integer> size) {
        this.setSize(size.first(), size.second());
        this.figures.add(new BackgroundDecorator(new ThingA(50, 50), Color.RED));
        this.figures.add(new BorderDecorator(new ThingB(100, 100), Color.BLACK));
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    public void startAnimations() {
        this.animationThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                this.figures.forEach(f -> f.accept(this.animator));
                this.repaint();
                sleep(100);
            }
        });

        this.animationThread.start();
    }

    public void stopAnimations() {
        this.animationThread.interrupt();
    }

    @Override
    public void draw(Graphics g) {
        this.figures.forEach(figure -> figure.draw(g));
    }
}
