/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIElements;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 *
 * @author thnrg
 */
public final class RoundJPasswordField extends JPasswordField{
    private Shape shape;
    protected String placeholder;
    
    public RoundJPasswordField(int size, String placeholder) {
        super(size);
        this.placeholder = placeholder;
        AddPlaceholder();
        setOpaque(false);
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                RemovePlaceholder();
            }
            @Override
            public void focusLost(FocusEvent e) {
                AddPlaceholder();
            }
        });
    }
    
    public RoundJPasswordField(int size) {
        super(size);
        AddPlaceholder();
        setOpaque(false);
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                RemovePlaceholder();
            }
            @Override
            public void focusLost(FocusEvent e) {
                AddPlaceholder();
            }
        });
    }
    
    protected void RemovePlaceholder()
    {
        if (new String(super.getPassword()).equals(this.placeholder)) {
            this.setEchoChar('*');
            super.setText("");
            this.setForeground(Color.BLACK);
        }
    }
    
    protected void AddPlaceholder()
    {
        if (new String(super.getPassword()).isEmpty()) {
            this.setEchoChar((char) 0);
            this.setForeground(Color.GRAY);
            super.setText(this.placeholder);
        }
    }
    
    @Override
    public char[] getPassword()
    {
        RemovePlaceholder();
        char[] pass = super.getPassword();
        AddPlaceholder();
        return pass;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g2);
        g2.dispose();
    }
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        g2.dispose();
    }
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
