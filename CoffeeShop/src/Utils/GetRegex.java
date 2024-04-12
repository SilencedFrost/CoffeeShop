/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author thnrg
 */
public class GetRegex {
    public static String getUsernameRegex()
    {
        return Tools.getProps("regex").getProperty("username");
    }
    
    public static String getPasswordRegex()
    {
        return Tools.getProps("regex").getProperty("password");
    }
    
    public static String getEmailRegex()
    {
        return Tools.getProps("regex").getProperty("email");
    }
    
    public static String getPhoneRegex()
    {
        return Tools.getProps("regex").getProperty("phone");
    }
    
    public static String getProductIDRegex()
    {
        return Tools.getProps("regex").getProperty("productid");
    }
    
    public static String getPositiveFloatRegex()
    {
        return Tools.getProps("regex").getProperty("positivefloat");
    }
}
