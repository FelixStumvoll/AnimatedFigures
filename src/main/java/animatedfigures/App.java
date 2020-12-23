package animatedfigures;

import animatedfigures.ui.MainPanel;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class App implements Runnable {
    public static void main(String[] args) {
        var width = 700;
        var height = 500;
        var frame = new JFrame("Animated Figures");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var mainPanel = new MainPanel(width, height);
        frame.getContentPane().add(mainPanel);
        mainPanel.startAnimations();
        frame.setSize(width, height);
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
