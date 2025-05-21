/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author thnrg
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class AddressService {
    private static final Logger logger = Logger.getLogger(AddressService.class.getName());

    public static ArrayList<String> getCities() {
        ArrayList<String> cities = new ArrayList<>();
        try (Connection con = DBUtils.getCon();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT full_name FROM provinces")) {

            while (rs.next()) {
                cities.add(rs.getString("full_name"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to load cities from database", ex);
        }
        return cities;
    }

    public static ArrayList<String> getDistricts(String cityName) {
        ArrayList<String> districts = new ArrayList<>();
        if (cityName == null || cityName.isEmpty()) {
            logger.warning("City name is null or empty in getDistricts");
            return districts;
        }

        try (Connection con = DBUtils.getCon();
             PreparedStatement stm = con.prepareStatement(
                     "SELECT full_name FROM districts WHERE province_code IN (SELECT code FROM provinces WHERE full_name LIKE ?)")) {
            stm.setNString(1, cityName);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    districts.add(rs.getString("full_name"));
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to load districts from database", ex);
        }
        return districts;
    }

    public static ArrayList<String> getWards(String districtName) {
        ArrayList<String> wards = new ArrayList<>();
        if (districtName == null || districtName.isEmpty()) {
            logger.warning("District name is null or empty in getWards");
            return wards;
        }

        try (Connection con = DBUtils.getCon();
             PreparedStatement stm = con.prepareStatement(
                     "SELECT full_name FROM wards WHERE district_code IN (SELECT code FROM districts WHERE full_name LIKE ?)")) {
            stm.setNString(1, districtName);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    wards.add(rs.getString("full_name"));
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to load wards from database", ex);
        }
        return wards;
    }
}
