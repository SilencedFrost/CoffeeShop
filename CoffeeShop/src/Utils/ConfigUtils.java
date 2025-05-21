/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author thnrg
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;
import java.util.logging.*;

public class ConfigUtils {
    private static final Logger logger = Logger.getLogger(ConfigUtils.class.getName());
    
    private static Properties connectionProps = null;
    private static Properties regexProps = null;

    /**
     *
     * @param filename
     * Get the props from default relative path of src/Configs/
     * @return
     */
    public static Properties getProps(String filename) {
        String path = "src/Configs/" + filename + ".properties";
        return getPropsFromPath(path);
    }

    public static Properties getPropsFromPath(String filepath) {
        try (FileReader reader = new FileReader(filepath)) {
            Properties prop = new Properties();
            prop.load(reader);
            return prop;
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Failed to load properties file: " + filepath, ex);
        }
        return null;
    }

    public static Properties getPropsFromPath(Path path) {
        try (FileReader reader = new FileReader(path.toFile())) {
            Properties prop = new Properties();
            prop.load(reader);
            return prop;
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Failed to load properties file: " + path.toString(), ex);
        }
        return null;
    }

    public static Properties getPropsFromInputStream(InputStream inputStream) {
        try (InputStream is = inputStream) {
            Properties prop = new Properties();
            prop.load(is);
            return prop;
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Failed to load properties from InputStream", ex);
        }
        return null;
    }

    private static void loadConnectionProps() {
        if (connectionProps == null) {
            connectionProps = getProps("connection");
            if (connectionProps == null) {
                logger.log(Level.SEVERE, "Failed to load connection properties.");
                connectionProps = new Properties();
            }
        }
    }

    private static void loadRegexProps() {
        if (regexProps == null) {
            regexProps = getProps("regex");
            if (regexProps == null) {
                logger.log(Level.SEVERE, "Failed to load regex properties.");
                regexProps = new Properties();
            }
        }
    }

    // Connection props
    public static String getDBName() {
        loadConnectionProps();
        return connectionProps.getProperty("dbname");
    }

    public static String getUsername() {
        loadConnectionProps();
        return connectionProps.getProperty("username");
    }

    public static String getPassword() {
        loadConnectionProps();
        return connectionProps.getProperty("pass");
    }

    // Regex props
    public static String getUsernameRegex() {
        loadRegexProps();
        return regexProps.getProperty("username");
    }

    public static String getPasswordRegex() {
        loadRegexProps();
        return regexProps.getProperty("password");
    }

    public static String getEmailRegex() {
        loadRegexProps();
        return regexProps.getProperty("email");
    }

    public static String getPhoneRegex() {
        loadRegexProps();
        return regexProps.getProperty("phone");
    }

    public static String getProductIDRegex() {
        loadRegexProps();
        return regexProps.getProperty("productid");
    }

    public static String getPositiveFloatRegex() {
        loadRegexProps();
        return regexProps.getProperty("positivefloat");
    }
}
