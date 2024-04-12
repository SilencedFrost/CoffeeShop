/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Customer;
import java.sql.*;
import Utils.Tools;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
            if(rs.next())
            {
                return rs.getInt("position");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public static void deleteUser(int userid)
    {
        try (Connection con = Tools.GetCon())
        {
            PreparedStatement stm = con.prepareStatement("delete Customer where userid = ?");
            stm.setInt(1, userid);
            stm.execute();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void resetPass(int userid)
    {
        try (Connection con = Tools.GetCon())
        {
            Statement stm = con.createStatement();
            stm.execute("EXEC ResetPass " + userid);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static boolean AddUser(String username, String email, String password, int position)
    {
        try (Connection con = Tools.GetCon()) {
        CallableStatement cstmt = con.prepareCall("{CALL AddUser(?, ?, ?, ?, null, null, ?)}");

        cstmt.setString(1, username);
        cstmt.setString(2, email);
        cstmt.setString(3, password);
        cstmt.setInt(4, position);
        cstmt.registerOutParameter(5, Types.INTEGER); // Output parameter for success/fail

        cstmt.execute();

        int success = cstmt.getInt(5); // Retrieve the output parameter

        return success == 1;
        } 
        catch (Exception ex) 
        {
        ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean AddUser(String username, String email, String password, int position, boolean gender)
    {
        try (Connection con = Tools.GetCon()) {
        CallableStatement cstmt = con.prepareCall("{CALL AddUser(?, ?, ?, ?, ?, null, ?)}");

        cstmt.setString(1, username);
        cstmt.setString(2, email);
        cstmt.setString(3, password);
        cstmt.setInt(4, position);
        cstmt.setBoolean(5, gender);
        cstmt.registerOutParameter(6, Types.INTEGER); // Output parameter for success/fail

        cstmt.execute();

        int success = cstmt.getInt(6); // Retrieve the output parameter

        return success == 1;
        } 
        catch (Exception ex) 
        {
        ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean AddUser(String username, String email, String password, int position, boolean gender, String phone)
    {
        try (Connection con = Tools.GetCon()) {
        CallableStatement cstmt = con.prepareCall("{CALL AddUser(?, ?, ?, ?, ?, ?, ?)}");

        cstmt.setString(1, username);
        cstmt.setString(2, email);
        cstmt.setString(3, password);
        cstmt.setInt(4, position);
        cstmt.setBoolean(5, gender);
        cstmt.setString(6, phone);
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
    
    public static void updateUser(int userID, String email, boolean gender, String phone)
    {
        try(Connection con = Tools.GetCon())
        {
            PreparedStatement stm = con.prepareStatement("Update customer set email = ?, gender = ?, phone = ? where userid = ?");
            stm.setString(1, email);
            stm.setBoolean(2, gender);
            stm.setString(3, phone);
            stm.setInt(4, userID);
            
            stm.execute();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
        public static ArrayList<Customer> loadAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try (Connection con = Tools.GetCon();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customer")) {

            while (rs.next()) {
                int userID = rs.getInt("userID");
                String username = rs.getString("username");
                int position = rs.getInt("position");
                String email = rs.getString("email");
                boolean gender = rs.getBoolean("gender");
                String phone = rs.getString("phone");
                String exactloc = rs.getString("exactloc");
                String ward = rs.getString("ward");
                String district = rs.getString("district");
                String city = rs.getString("city");

                // Create a new Customer object excluding the password field
                Customer customer = new Customer(userID, username, position, email, gender, phone, exactloc, ward, district, city);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return customers;
    }
        
    public static DefaultTableModel loadToTable(ArrayList<Customer> customers) {
        // Define column names for the table
        String[] columnNames = {"UserID", "Username", "Position", "Email", "Gender", "Phone", "Exact Location", "Ward", "District", "City"};

        // Initialize data array for the table
        Object[][] data = new Object[customers.size()][columnNames.length];

        // Populate data array with customer information
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            data[i][0] = customer.getUserID();
            data[i][1] = customer.getUsername();
            data[i][2] = customer.getPosition();
            data[i][3] = customer.getEmail();
            data[i][4] = customer.isGender() ? "Male" : "Female";
            data[i][5] = customer.getPhone();
            data[i][6] = customer.getExactloc();
            data[i][7] = customer.getWard();
            data[i][8] = customer.getDistrict();
            data[i][9] = customer.getCity();
        }

        // Create DefaultTableModel with data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        return model;
    }
    
    public static ArrayList<Customer> filterCustomers(ArrayList<Customer> customers, String filterProperty, Object filterValue) 
    {
        ArrayList<Customer> filteredCustomers = new ArrayList<>();

        // Iterate through each customer in the list
        for (Customer customer : customers) {
            // Check if the customer's property matches the filter value
            switch (filterProperty) {
                case "userID" -> {
                    if (customer.getUserID() == (int) filterValue) {
                        filteredCustomers.add(customer);
                    }
                }
                case "username" -> {
                    if (customer.getUsername().contains((String) filterValue)) {
                        filteredCustomers.add(customer);
                    }
                }
                case "position" -> {
                    if (customer.getPosition() == (int) filterValue) {
                        filteredCustomers.add(customer);
                    }
                }
                case "username-userid" -> {
                    String filterString = (String) filterValue;
                    int userID;
                    try {
                        userID = Integer.parseInt(filterString);
                        if (customer.getUserID() == userID || customer.getUsername().contains(filterString)) {
                            filteredCustomers.add(customer);
                        }
                    } catch (NumberFormatException e) {
                        // Not a valid integer, treat as username
                        if (customer.getUsername().contains(filterString)) {
                            filteredCustomers.add(customer);
                        }
                    }
                }
                default -> System.out.println("Invalid filter property");
            }
        }

        return filteredCustomers;
    }
}
