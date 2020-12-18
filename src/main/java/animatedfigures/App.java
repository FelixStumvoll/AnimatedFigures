package animatedfigures;

import animatedfigures.ui.MainPanel;
import animatedfigures.util.Pair;

import javax.swing.*;

public class App implements Runnable {
    public static void main(String[] args) {
        var size = Pair.of(500, 500);
        var frame = new JFrame("Animated Figures");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane()
                .add(new MainPanel(size));
        frame.setSize(size.first(), size.second());
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(new App());
    }
}
