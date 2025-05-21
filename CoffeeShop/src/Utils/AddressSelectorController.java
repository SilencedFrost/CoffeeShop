/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author thnrg
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.logging.*;

public class AddressSelectorController {
    private static final Logger logger = Logger.getLogger(AddressSelectorController.class.getName());

    /**
     * Update combo boxes according to status:
     * 0 - update cities, districts, wards
     * 1 - update districts and wards
     * 2 - update wards only
     * @param cboCity
     * @param cboDistrict
     * @param cboWard
     * @param status
     */
    public static void addressSelector(JComboBox<String> cboCity, JComboBox<String> cboDistrict, JComboBox<String> cboWard, int status) {
        try {
            if (status <= 0) {
                ArrayList<String> cities = AddressService.getCities();
                SwingUtilities.invokeLater(() -> UIUtils.loadComboBox(cboCity, cities));
            }

            if (status <= 1) {
                Object selectedCity = cboCity.getSelectedItem();
                ArrayList<String> districts = AddressService.getDistricts(selectedCity != null ? selectedCity.toString() : null);
                SwingUtilities.invokeLater(() -> UIUtils.loadComboBox(cboDistrict, districts));
            }

            if (status <= 2) {
                Object selectedDistrict = cboDistrict.getSelectedItem();
                ArrayList<String> wards = AddressService.getWards(selectedDistrict != null ? selectedDistrict.toString() : null);
                SwingUtilities.invokeLater(() -> UIUtils.loadComboBox(cboWard, wards));
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed in addressSelector", ex);
        }
    }
}
