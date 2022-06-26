package com.pragmatic.selenium.newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/**
 * Demonstrates use of Selenium 4 new feature, managing window/tabs
 */
public class WindowManagement {



    @Test
    public void testOpenNewWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("http://pragmatictestlabs.com");
        driver.quit();
    }


    @Test
    public void testOpenNewTab(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("http://pragmatictestlabs.com");
        driver.quit();
    }



}
