/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import simulation.Flock;
import simulation.FlockManager;
import simulation.data.Bird;

/**
 *
 * @author Jake
 */
public class Screen extends JPanel {

    private final FlockManager flockManager;

    public Screen(int width, int height, FlockManager flockManager) {
        this.flockManager = flockManager;

        JFrame frame = new JFrame("Flock Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        this.setPreferredSize(new Dimension(width, height));
        frame.getContentPane().add(this);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        draw(g2d);
    }

    private void draw(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1000, 1000);

        Flock[] flocks = flockManager.flock();
        for (Flock flock : flocks) {

            g2d.setColor(flock.color());

            Bird[] birds = flock.get();
            for (Bird b : birds) {
                g2d.fillOval(pixelX(b.pos.x) - 3, pixelY(b.pos.y) - 3, 7, 7);
            }
        }
    }

    private int pixelX(double x) {
        double screenX = x + (this.getWidth() / 2);
        return (int) Math.round(screenX);
    }

    private int pixelY(double y) {
        double screenY = (this.getHeight() / 2) - y;
        return (int) Math.round(screenY);
    }
}
