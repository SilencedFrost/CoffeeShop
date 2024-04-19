/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author thnrg
 */
public class RoundJPanel extends JPanel{
    private int arcWidth = 30; // The width of the rounded corners
    private int arcHeight = 30; // The height of the rounded corners

    public RoundJPanel() {
        setOpaque(false); // Make sure the background is transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // Draw rounded rectangle
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 150); // Set preferred size
    }
}
