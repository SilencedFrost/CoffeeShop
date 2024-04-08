/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;

/**
 *
 * @author thnrg
 */
public final class RoundJTextField extends JTextField{
    private Shape shape;
    protected String placeholder;
    
    public RoundJTextField(int size, String placeholder) {
        super(size);
        this.placeholder = placeholder;
        addPlaceholder();
        setOpaque(false); // As suggested by @AVD in comment.
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                removePlaceholder();
            }
            @Override
            public void focusLost(FocusEvent e) {
                addPlaceholder();
            }
        });
    }
    
    public RoundJTextField(int size) {
        super(size);
        addPlaceholder();
        setOpaque(false); // As suggested by @AVD in comment.
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                removePlaceholder();
            }
            @Override
            public void focusLost(FocusEvent e) {
                addPlaceholder();
            }
        });
    }
    
    protected void removePlaceholder()
    {
        if (super.getText().equals(this.placeholder)) {
            super.setText("");
            this.setForeground(Color.BLACK);
        }
    }
    
    protected void addPlaceholder()
    {
        if (super.getText().isEmpty()) {
            this.setForeground(Color.GRAY);
            super.setText(this.placeholder);
        }
    }
    
    @Override
    public String getText()
    {
        removePlaceholder();
        String txt = super.getText();
        addPlaceholder();
        return txt;
    }
    
    @Override
    public void setText(String t)
    {
        if(t.equals(""))
        {
            addPlaceholder();
        }
        else
        {
            super.setText(t);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    @Override
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
}
