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
        return Tools.getProps().getProperty("username");
    }
    
    public static String getPasswordRegex()
    {
        return Tools.getProps().getProperty("password");
    }
    
    public static String getEmailRegex()
    {
        return Tools.getProps().getProperty("email");
    }
    
    public static String getPhoneRegex()
    {
        return Tools.getProps().getProperty("phone");
    }
    
    public static String getProductIDRegex()
    {
        return Tools.getProps().getProperty("productid");
    }
}
