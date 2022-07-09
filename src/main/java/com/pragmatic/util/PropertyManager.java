package com.pragmatic.util;

import org.apache.commons.io.LineIterator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static String BROWSER_TYPE;
    private static Properties pros;
    private static String BASE_URL;
    private static String ADMIN_USERNAME;
    private static String ADMIN_PASSWORD;

    static {
        FileInputStream input = null;
        try {
            input = new FileInputStream("conf/selenium.properties");
            pros = new Properties();
            pros.load(input);
            BASE_URL = pros.getProperty("base.url");
            ADMIN_USERNAME = pros.getProperty("user.name");
            ADMIN_PASSWORD = pros.getProperty("user.password");
            BROWSER_TYPE = pros.getProperty("browser.type=");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowserType() {
        return BROWSER_TYPE;
    }


    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getAdminUsername() {
        return ADMIN_USERNAME;
    }

    public static String getAdminPassword() {
        return ADMIN_PASSWORD;
    }
}
