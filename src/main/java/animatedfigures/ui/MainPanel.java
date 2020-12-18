package animatedfigures.ui;

import animatedfigures.ui.figures.ThingA;
import animatedfigures.ui.shapes.base.ShapeGroup;
import animatedfigures.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainPanel extends JPanel implements Drawable {

    private final List<ShapeGroup> figures = new CopyOnWriteArrayList<>();

    public MainPanel(Pair<Integer, Integer> size) {
        this.setSize(size.first(), size.second());
        this.figures.add(new ThingA(50, 50));
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    @Override
    public void draw(Graphics g) {
        this.figures.forEach(figure -> figure.draw(g));
    }
}
