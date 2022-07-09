package com.pragmatic.examples.configuration;

import com.pragmatic.util.PropertyManager;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReadPropertiesFromConfFileExample {


    @Test
    public void readProperties() throws IOException {
        //Read the property file and assign to FileInputStream
        System.out.println(String.format("Base URL %s", PropertyManager.getBaseUrl()));
        System.out.println(String.format("Username %s",PropertyManager.getAdminUsername()));
        System.out.println(String.format("Password %s", PropertyManager.getAdminPassword()));
    }
}
