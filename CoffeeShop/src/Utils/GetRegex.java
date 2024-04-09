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
 * @author thnrg
 */
public class GetRegex {
    public static String getUsernameRegex()
    {
        return getProps().getProperty("username");
    }
    
    public static String getPasswordRegex()
    {
        return getProps().getProperty("password");
    }
    
    public static String getEmailRegex()
    {
        return getProps().getProperty("email");
    }
    
    public static String getPhoneRegex()
    {
        return getProps().getProperty("phone");
    }
    
    public static Properties getProps()
    {
        try
        {
            FileReader reader = new FileReader("src/Utils/regex.properties");
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
