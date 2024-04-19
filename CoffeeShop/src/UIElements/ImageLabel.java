/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIElements;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
/**
 *
 * @author thnrg
 */
public class ImageLabel extends JLabel {
    private BufferedImage img;
    private int cornerRadius;

    public ImageLabel(int cornerRadius) {
        super();
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }

    public void setImage(String imagePath) {
        try {
            img = ImageIO.read(new File(imagePath));
            Image scaledImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            img = null;
            setIcon(null);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        super.paintComponent(g2d);
    }
}
