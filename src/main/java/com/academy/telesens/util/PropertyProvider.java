package com.academy.telesens.util;

import com.academy.telesens.lesson16.LoggingDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {
    private static Logger LOG = LoggerFactory.getLogger(PropertyProvider.class);

    private static final String DEFAULT_PROP_FILE = "default-cfg.properties";
    private static Properties prop;

    // блок статической инициализации
    static {
        init();
    }

    private static void init() {
        try {
            prop = new Properties();
            InputStream is = PropertyProvider.class.getClassLoader().getResourceAsStream(DEFAULT_PROP_FILE);
            prop.load(is); // загружаем физический файл с пропертями
        } catch (IOException | RuntimeException e) {
            LOG.error("Error prop initialization. Details: {}", e.getMessage());
        }
    }

    // метод отдает проперти по ключу
    public static String get(String key) {
       return prop.getProperty(key);
    }
}
