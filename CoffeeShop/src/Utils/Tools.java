/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thnrg
 */
public class Tools 
{
    public static void SetIcon(JLabel container, String imgpath)
    {
        ImageIcon icon = new ImageIcon(imgpath);
        Image image = icon.getImage();
        Image scaled = image.getScaledInstance(container.getWidth(), container.getHeight(), java.awt.Image.SCALE_SMOOTH);
        container.setIcon(new ImageIcon(scaled));
        
    }
    
    public static void SetFrameToCenter (JFrame frame)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }
    
    public static void SetFrameToCenter (JDialog frame)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }
    
    public static Connection GetCon()
    {
        try
        {
            Connection conn = DriverManager.getConnection(getConInfo());
            return conn;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static String getConInfo()
    {
        return "jdbc:sqlserver://localhost:1433;databaseName=" + ReadProps.getDBName() + ";username=" + ReadProps.getUsername() + ";password=" + ReadProps.getPassword();
    }
    
    public static void loadComboBox(JComboBox comboBox, ArrayList<String> data) {
        comboBox.removeAllItems();

        for (String item : data) {
            comboBox.addItem(item);
        }
    }
    
    public static DefaultTableModel trimColumns(DefaultTableModel model, int desiredLength) {
        int currentLength = model.getColumnCount();
        if (currentLength > desiredLength) {
            for (int i = currentLength - 1; i >= desiredLength; i--) {
                model.setColumnCount(i);
            }
        }
        return model;
    }
    
    public static void setLAF()
    {
        try 
        {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } 
        catch (UnsupportedLookAndFeelException ex) 
        {
            
        }
    }
}
