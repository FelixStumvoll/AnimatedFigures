package animatedfigures.ui;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.decorators.BackgroundDecorator;
import animatedfigures.ui.shapes.decorators.BorderDecorator;
import animatedfigures.ui.shapes.impl.AnimatedShapeGroup;
import animatedfigures.ui.visitor.impl.FillFlipVisitor;
import animatedfigures.ui.visitor.impl.MoveVisitor;
import animatedfigures.ui.visitor.impl.ResizeVisitor;
import animatedfigures.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static animatedfigures.util.ThreadUtil.sleep;

public class MainPanel extends JPanel implements Drawable {

    private final List<AnimatedShapeGroup> figures = new ArrayList<>();
    private Thread animationThread;

    public MainPanel(Pair<Integer, Integer> size) {
        this.setSize(size.first(), size.second());
        this.figures.add(
                new AnimatedShapeGroup(
                        new BackgroundDecorator(new ThingA(50, 50), Color.RED),
                        new MoveVisitor(0, 100),
                        new FillFlipVisitor()
                ));
        this.figures.add(new AnimatedShapeGroup(
                new BorderDecorator(new ThingB(100, 100), Color.magenta),
                new ResizeVisitor(10, 50, 1),
                new FillFlipVisitor()));
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
                this.figures.forEach(AnimatedShapeGroup::animate);
                this.repaint();
                sleep(200);
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
