package com.pragmatic.examples.configuration;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFileExample {


    public static void main(String[] args) {

        try (InputStream input = new FileInputStream("src/test/resources/ptl-hrm.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("base.url"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
