package com.pragmatic.hrm;

import org.testng.annotations.DataProvider;

public class HRMData {

    @DataProvider(name = "login-inputs")
    public static Object[][] loginInputs(){
        return new Object[][]{
                {"", "", "Username cannot be empty"},
                {"", "Ptl@#321", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "invalid", "Invalid credentials"}
        };
    }
}
