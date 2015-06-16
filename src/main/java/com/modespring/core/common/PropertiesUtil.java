package com.modespring.core.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by Shawoe on 2015/6/16.
 */
public class PropertiesUtil {

    public static Integer getIntegerProperty(String file, String key) {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        try {
            properties.load(file + ".properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(properties.getString(key));
    }

    public static String getStringProperty(String file, String key) {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        try {
            properties.load(file + ".properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return properties.getString(key);
    }

    public static String[] getStringProperties(String file, String key) {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        try {
            properties.load(file + ".properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return properties.getString(key).split("\\|");
    }

}
