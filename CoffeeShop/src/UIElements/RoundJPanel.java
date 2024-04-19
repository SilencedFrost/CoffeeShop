/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UIElements;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author thnrg
 */

public class RoundJPanel extends JPanel {
    private final int arcWidth;
    private final int arcHeight;

    public RoundJPanel(int borderRad) {
        this.arcWidth = borderRad;
        this.arcHeight = borderRad;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        g2.dispose();
    }
}
