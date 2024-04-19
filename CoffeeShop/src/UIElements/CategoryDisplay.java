/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIElements;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author thnrg
 */
public class CategoryDisplay {
    private final JPanel pnOutline;
    private final JPanel pnItems;
    
    public void addProducts(JPanel item)
    {
        pnItems.add(item);
    }
    
    public CategoryDisplay(String text) {
        pnOutline = new JPanel();
        pnItems = new JPanel();
        pnOutline.setLayout(new BoxLayout(pnOutline,BoxLayout.Y_AXIS));
        pnOutline.setBackground(Color.white);
        
        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
        pnTitle.add(label);
        pnTitle.setBackground(Color.white);
        
        pnOutline.add(pnTitle);
        
        pnItems.setLayout(new WrapLayout(WrapLayout.LEFT));
        pnItems.setBackground(Color.white);
        pnOutline.add(pnItems);
        
    }

    public JPanel getPanel() {
        return pnOutline;
    }
    
    public boolean checkChild()
    {
        return pnItems.getComponentCount() != 0;
    }
}
