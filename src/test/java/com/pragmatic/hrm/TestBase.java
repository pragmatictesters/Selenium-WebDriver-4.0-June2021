package com.pragmatic.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite
    public void beforeSuite(){

        String browserType = "chrome";

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        }
    }
}
