package com.pragmatic.hrm;

import org.testng.annotations.DataProvider;

public class TestData {


    @DataProvider(name = "data-provider-login-inputs")
    public static Object[][] userCredentials(){
        return new Object[][] {
                {"", "", "Username cannot be empty"},
                {"", "Ptl@#321", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "invalid", "Invalid credentials"},
        };
    }
}
