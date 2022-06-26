package com.pragmatic.examples.browsers;

import com.pragmatic.temp.SystemExample;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Firefox {


    @Test
    public void testLaunchBrowser(){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "/Users/admin/Documents/teaching/selenium/selenium-sweden/SeleniumSweden/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
    }
}
