/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author thnrg
 */

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UIUtils {
    private static final Logger logger = Logger.getLogger(UIUtils.class.getName());

    public static void setIcon(JLabel container, String imgPath) {
        ImageIcon icon = new ImageIcon(imgPath);
        Image image = icon.getImage();
        Image scaled = image.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        container.setIcon(new ImageIcon(scaled));
    }

    public static void loadComboBox(JComboBox<String> comboBox, ArrayList<String> data) {
        comboBox.removeAllItems();
        for (String item : data) {
            comboBox.addItem(item);
        }
    }

    public static DefaultTableModel trimColumns(DefaultTableModel model, int desiredLength) {
        int currentLength = model.getColumnCount();
        if (currentLength > desiredLength) {
            model.setColumnCount(desiredLength);
        }
        return model;
    }

    public static void setLAF() {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            logger.log(Level.SEVERE, "Failed to set Look and Feel", ex);
        }
    }
}
