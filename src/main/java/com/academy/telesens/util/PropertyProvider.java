package com.academy.telesens.util;

import com.academy.telesens.lesson12.MySQLDemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {
    private static final String DEFAULT_PROP_FILE = "default-cfg.properties";
    public static String get(String key) {
        try {
            InputStream is = PropertyProvider.class.getClassLoader().getResourceAsStream(DEFAULT_PROP_FILE);
            Properties prop = new Properties();
            prop.load(is);
            String value = prop.getProperty(key);
            return value;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
