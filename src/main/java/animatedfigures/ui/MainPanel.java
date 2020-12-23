package animatedfigures.ui;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.figures.ThingB;
import animatedfigures.ui.shapes.decorators.BackgroundDecorator;
import animatedfigures.ui.shapes.decorators.BorderDecorator;
import animatedfigures.ui.shapes.impl.AnimatedShapeGroup;
import animatedfigures.ui.visitor.impl.FillFlipVisitor;
import animatedfigures.ui.visitor.impl.MoveVisitor;
import animatedfigures.ui.visitor.impl.ResizeVisitor;
import animatedfigures.ui.visitor.impl.RotateVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static animatedfigures.util.ThreadUtil.sleep;

public class MainPanel extends JPanel {

    private final List<AnimatedShapeGroup> figures;
    private Thread animationThread;

    public MainPanel(int width, int height) {
        this.setSize(width, height);
        this.figures = List.of(
                new AnimatedShapeGroup(
                        new BackgroundDecorator(new ThingA(60, 50), Color.RED),
                        new MoveVisitor(0, 500, 5),
                        new FillFlipVisitor(),
                        new RotateVisitor()
                ),
                new AnimatedShapeGroup(
                        new ThingB(400, 250),
                        new RotateVisitor(),
                        new ResizeVisitor(0, 150, 1, true)
                ),
                new AnimatedShapeGroup(
                        new BorderDecorator(new ThingB(100, 250), Color.magenta),
                        new ResizeVisitor(10, 20, 30, 40),
                        new FillFlipVisitor()));
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

}
