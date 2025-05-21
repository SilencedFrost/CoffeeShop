/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author thnrg
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.*;

public class DBUtils {
    private static final Logger logger = Logger.getLogger(DBUtils.class.getName());

    public static Connection getCon() {
        try {
            return DriverManager.getConnection(getConInfo());
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Failed to get connection", ex);
        }
        return null;
    }

    public static String getConInfo() {
        return "jdbc:sqlserver://localhost:1433;databaseName=" + ConfigUtils.getDBName()
                + ";username=" + ConfigUtils.getUsername()
                + ";password=" + ConfigUtils.getPassword();
    }
}
