/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.*;
import Utils.*;
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
        String[] columnNames = {"ProductID", "Name", "Description", "Visibility", "Add Date", "Price", "Picture", "Category"};

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
            data[i][7] = product.getCategory();
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
                case "visibility" ->
                {
                    if(product.isVisibility() == (boolean) filterValue)
                    {
                        filteredProducts.add(product);
                    }
                }
                case "category" ->
                {
                    if(product.getCategory() == (int) filterValue)
                    {
                        filteredProducts.add(product);
                    }
                }
            }
        }

        return filteredProducts;
    }

    public static ArrayList<Product> loadAllProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try (Connection con = DBUtils.getCon();
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
                int category = rs.getInt("category");

                // Create a new Product object
                Product product = new Product(productID, pdname, pddesc, visibility, adddate, price, picture, category);
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
        try(Connection con = DBUtils.getCon())
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
        try (Connection con = DBUtils.getCon()) {
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
        try(Connection con = DBUtils.getCon())
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
    
    public static ProductInfo getProductInfo(String productName)
    {
        ProductInfo pd = new ProductInfo();
        try(Connection con = DBUtils.getCon())
        {
            PreparedStatement stm = con.prepareStatement("Select * from product where pdName like ?");
            stm.setString(1, productName);
            ResultSet rs = stm.executeQuery();
            rs.next();
            pd.setProductName(rs.getString("pdName"));
            pd.setProductDesc(rs.getString("pdDesc"));
            setSize(pd, productName);
            pd.setPicture(rs.getString("picture"));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return pd;
    }
    
    public static String getSize(String productID)
    {
        return productID.substring(productID.length() - 1);
    }
    
    public static void setSize(ProductInfo pd, String productName)
    {
        try(Connection con = DBUtils.getCon())
        {
            PreparedStatement stm = con.prepareStatement("Select * from product where pdName like ?");
            stm.setString(1, productName);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                switch(getSize(rs.getString("productID")))
                {
                    case "S" ->
                    {
                        if(rs.getBoolean("visibility"))
                        {
                            pd.setS(true);
                            pd.setPriceS(rs.getFloat("price"));
                        }
                        
                    }
                    case "M" ->
                    {
                        if(rs.getBoolean("visibility"))
                        {
                            pd.setM(true);
                            pd.setPriceM(rs.getFloat("price"));
                        }
                    }
                    case "L" ->
                    {
                        if(rs.getBoolean("visibility"))
                        {
                            pd.setL(true);
                            pd.setPriceL(rs.getFloat("price"));
                        }
                    }
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
