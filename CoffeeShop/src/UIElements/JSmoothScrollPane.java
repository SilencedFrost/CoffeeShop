/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UIElements;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author thnrg
 */
public class JSmoothScrollPane extends JScrollPane {
    private int unitIncrement;

    public JSmoothScrollPane(Component view, int unitIncrement) {
        super(view);
        this.unitIncrement = unitIncrement;
        getVerticalScrollBar().setUnitIncrement(unitIncrement);

        // Add a MouseWheelListener for smooth scrolling
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                JScrollBar bar = getVerticalScrollBar();
                if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
                    int totalScrollAmount = e.getUnitsToScroll() * unitIncrement;
                    smoothScrollTo(bar.getValue() + totalScrollAmount);
                }
            }
        });
    }

    public void smoothScrollTo(int y) {
        Timer timer = new Timer(30, new ActionListener() {
            int i = getVerticalScrollBar().getValue();
            public void actionPerformed(ActionEvent e) {
                if (i < y) {
                    getVerticalScrollBar().setValue(i);
                    i += unitIncrement;
                } else {
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
}
