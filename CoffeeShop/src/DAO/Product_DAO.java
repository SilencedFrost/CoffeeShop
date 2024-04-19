/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Product;
import Utils.Tools;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author thnrg
 */
public class Product_DAO {
    public static DefaultTableModel loadToTable(ArrayList<Product> products) {
        // Define column names for the table
        String[] columnNames = {"ProductID", "Name", "Description", "Visibility", "Add Date", "Price", "Picture"};

        // Initialize data array for the table
        Object[][] data = new Object[products.size()][columnNames.length];

        // Populate data array with product information
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getProductID();
            data[i][1] = product.getPdname();
            data[i][2] = product.getPddesc();
            data[i][3] = product.isVisibility() ? "Visible" : "Not Visible";
            data[i][4] = product.getAdddate();
            data[i][5] = product.getPrice();
            data[i][6] = product.getPicture();
        }

        // Create DefaultTableModel with data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        return model;
    }

    public static ArrayList<Product> filterProducts(ArrayList<Product> products, String filterProperty, Object filterValue) {
        ArrayList<Product> filteredProducts = new ArrayList<>();

        for (Product product : products) {
            switch (filterProperty) {
                case "productID" -> 
                {
                    if (product.getProductID().toLowerCase().contains(((String) filterValue).toLowerCase())) {
                        filteredProducts.add(product);
                    }
                }
                case "pdname" -> 
                {
                    if (product.getPdname().toLowerCase().contains(((String) filterValue).toLowerCase())) {
                        filteredProducts.add(product);
                    }
                }
                case "pdname-productID" ->
                {
                    if (product.getPdname().toLowerCase().contains(((String) filterValue).toLowerCase()) || product.getProductID().toLowerCase().contains(((String) filterValue).toLowerCase())) {
                        filteredProducts.add(product);
                    }
                }
            }
        }

        return filteredProducts;
    }

    public static ArrayList<Product> loadAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try (Connection con = Tools.GetCon();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Product")) 
        {

            while (rs.next()) 
            {
                String productID = rs.getString("productID");
                String pdname = rs.getString("pdname");
                String pddesc = rs.getString("pddesc");
                boolean visibility = rs.getBoolean("visibility");
                Date adddate = rs.getDate("adddate");
                float price = rs.getFloat("price");
                String picture = rs.getString("picture");

                // Create a new Product object
                Product product = new Product(productID, pdname, pddesc, visibility, adddate, price, picture);
                products.add(product);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }

        return products;
    }
    
    public static void deleteProduct(String productID)
    {
        try(Connection con = Tools.GetCon())
        {
            PreparedStatement stm = con.prepareStatement("delete product where productid like ?");
            stm.setString(1, productID);
            stm.execute();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static boolean AddProduct(String productID, String pdName, String pdDesc, boolean visibility, float price, String picture)
    {
        try (Connection con = Tools.GetCon()) {
        CallableStatement cstmt = con.prepareCall("{CALL AddProduct(?, ?, ?, ?, ?, ?, ?)}");

        cstmt.setString(1, productID);
        cstmt.setNString(2, pdName);
        cstmt.setNString(3, pdDesc);
        cstmt.setBoolean(4, visibility);
        cstmt.setFloat(5, price);
        cstmt.setString(6, picture);
        cstmt.registerOutParameter(7, Types.INTEGER); // Output parameter for success/fail

        cstmt.execute();

        int success = cstmt.getInt(7); // Retrieve the output parameter

        return success == 1;
        } 
        catch (Exception ex) 
        {
        ex.printStackTrace();
        }
        return false;
    }
    
    public static void updateProduct(String productID, String pdName, String pdDesc, boolean visibility, float price, String picture)
    {
        try(Connection con = Tools.GetCon())
        {
            PreparedStatement stm = con.prepareStatement("Update Product set pdname = ?, pddesc = ?, visibility = ?, price = ?, picture = ? where productid = ?");
            stm.setNString(1, pdName);
            stm.setNString(2, pdDesc);
            stm.setBoolean(3, visibility);
            stm.setFloat(4, price);
            stm.setString(5, picture);
            stm.setString(6, productID);
            stm.execute();
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
}
