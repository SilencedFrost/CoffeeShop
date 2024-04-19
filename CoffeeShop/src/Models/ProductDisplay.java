/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import UI.RoundJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

/**
 *
 * @author thnrg
 */
public class ProductDisplay {
    protected String picture;
    protected float price;
    protected String pdName;

    public ProductDisplay(String picture, float price, String pdName) {
        this.picture = picture;
        this.price = price;
        this.pdName = pdName;
    }
    
    public RoundJPanel getPanel()
    {
        RoundJPanel panel = new RoundJPanel();
        LayoutManager layout = new BorderLayout();
        panel.setLayout(layout);
        
        panel.setSize(new Dimension(200, 100));
        panel.setBackground(Color.red);
        return panel;
    }
}
