/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIElements;

import UI.ProductDialog;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
/**
 *
 * @author thnrg
 */
public class ProductDisplay {
    protected String picture;
    protected float price;
    protected String pdName;
    protected JPanel pnMain;

    public ProductDisplay(String picture, float price, String pdName) {
        this.picture = picture;
        this.price = price;
        this.pdName = pdName;
        pnMain = new JPanel();
        pnMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProductDialog pdDiag = new ProductDialog((JFrame)SwingUtilities.getWindowAncestor(pnMain), true);
                pdDiag.showProduct(pdName);
                pdDiag.setVisible(true);
            }
        });
        pnMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnMain.setPreferredSize(new Dimension(257, 350));
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        
        ImageLabel image = new ImageLabel(30);
        image.setSize(new Dimension(pnMain.getPreferredSize().width - 20, pnMain.getPreferredSize().width - 20));
        image.setImage(picture);
        pnMain.add(image);
        
        JLabel lblName = new JLabel(pdName);
        lblName.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 0));
        lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        pnMain.add(lblName);
        
        Locale vietnam = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(vietnam);
        String formattedPrice = numberFormat.format(price);
        formattedPrice = formattedPrice.substring(0, formattedPrice.length() - 2) + "VND";
        
        JLabel lblPrice = new JLabel(formattedPrice);
        lblPrice.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 0));
        lblPrice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        
        pnMain.add(lblPrice);
        
        pnMain.setBackground(Color.white);
    }
    
    public JPanel getPanel()
    {
        return pnMain;
    }
}
