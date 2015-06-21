package com.modespring.core.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by Shawoe on 2015/6/16.
 */
public class PropertiesUtil {

    public static Integer getIntegerProperty(String file, String key) throws ConfigurationException {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        properties.load(file + ".properties");
        return Integer.valueOf(properties.getString(key));
    }

    public static String getStringProperty(String file, String key) throws ConfigurationException {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        properties.load(file + ".properties");
        return properties.getString(key);
    }

    public static void createStringProperty(String file, String key, String value) throws ConfigurationException {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        properties.load(file + ".properties");
        properties.addProperty(key, value);
        properties.save(file + ".properties");
    }

    public static void updateStringProperty(String file, String key, String value) throws ConfigurationException {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        properties.load(file + ".properties");
        properties.clearProperty(key);
        properties.addProperty(key, value);
        properties.save(file + ".properties");
    }

    public static String[] getStringProperties(String file, String key) throws ConfigurationException {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        properties.load(file + ".properties");
        return properties.getString(key).split("\\|");
    }

}
