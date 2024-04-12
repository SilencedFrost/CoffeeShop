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
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        return model;
    }

    public static ArrayList<Product> filterProducts(ArrayList<Product> products, String filterProperty, Object filterValue) {
        ArrayList<Product> filteredProducts = new ArrayList<>();

        // Iterate through each product in the list
        for (Product product : products) {
            // Check if the product's property matches the filter value
            switch (filterProperty) {
                case "productID" -> {
                    if (product.getProductID().equals(filterValue)) {
                        filteredProducts.add(product);
                    }
                }
                case "pdname" -> {
                    if (product.getPdname().contains((String) filterValue)) {
                        filteredProducts.add(product);
                    }
                    // Add more cases for other properties if needed
                }
                // Add more cases for other properties if needed
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
}
