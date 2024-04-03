/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import Utils.Tools;

/**
 *
 * @author thnrg
 */
public class Customer_DAO {
    public static int Login(String username, String pass)
    {
        try(Connection con = Tools.GetCon())
        {
            PreparedStatement stm = con.prepareStatement("select * from UserLogin(?, ?)");
            stm.setString(1, username);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt("position");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public static boolean Register(String username, String email, String password)
    {
        try (Connection con = Tools.GetCon()) {
        CallableStatement cstmt = con.prepareCall("{CALL Register(?, ?, ?, ?)}");

        cstmt.setString(1, username);
        cstmt.setString(2, email);
        cstmt.setString(3, password);
        cstmt.registerOutParameter(4, Types.INTEGER); // Output parameter for success/fail

        cstmt.execute();

        int success = cstmt.getInt(4); // Retrieve the output parameter

        return success == 1;
        } 
        catch (Exception ex) 
        {
        ex.printStackTrace();
        }
        return false;
    }
}
