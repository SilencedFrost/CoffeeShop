/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author SIlencedFrost
 */
public class ReadProps {
    
    public static String getDBName()
    {
        return getProps().getProperty("dbname");
    }
    
    public static String getUsername()
    {
        return getProps().getProperty("username");
    }
    
    public static String getPassword()
    {
        return getProps().getProperty("pass");
    }
    
    public static Properties getProps()
    {
        try
        {
            FileReader reader = new FileReader("src/Utils/connection.properties");
            Properties prop = new Properties();
            prop.load(reader);
            return prop;
        }
        catch(IOException ex)
        {
            
        }
        return null;
    }
}
