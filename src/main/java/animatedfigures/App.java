package animatedfigures;

import animatedfigures.ui.MainPanel;
import animatedfigures.util.Pair;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class App implements Runnable {
    public static void main(String[] args) {
        var size = Pair.of(500, 500);
        var frame = new JFrame("Animated Figures");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var mainPanel = new MainPanel(size);
        frame.getContentPane().add(mainPanel);
        mainPanel.startAnimations();
        frame.setSize(size.first(), size.second());
        frame.setResizable(false);
        frame.setVisible(true);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                mainPanel.stopAnimations();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(new App());
    }
}
