/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.Tools;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author thnrg
 */
public class Category_DAO {
    
    public static ArrayList<String> getCategories()
    {
        ArrayList<String> cateNames = new ArrayList();;
        try(Connection con = Tools.getCon())
        {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select cateName from category");
            while(rs.next())
            {
                cateNames.add(rs.getString("cateName"));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cateNames;
    }
    
    public static int getCateID(String cateName)
    {
        int result = 0;
        try(Connection con = Tools.getCon())
        {
            PreparedStatement stm = con.prepareStatement("Select cateID from category where cateName like ?");
            stm.setString(1, cateName);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                result = rs.getInt("cateID");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return result;
    }
}
