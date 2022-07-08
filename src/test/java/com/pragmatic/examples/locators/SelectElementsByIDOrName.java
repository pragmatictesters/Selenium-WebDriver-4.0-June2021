package com.pragmatic.examples.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectElementsByIDOrName {

    WebDriver driver;

    @BeforeClass()
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterClass()
    public void afterClass() {
        driver.close();
    }


    @BeforeMethod()
    public void beforeMethod() {
        driver.get("http://hrm.pragmatictestlabs.com");
    }


    /**
     * This example demonstrates use of ByIdOrName support class for locating elements
     */
    @Test()
    public void locateElementsByIdOrName() {
        //Type username
        driver.findElement(new ByIdOrName("txtUsername")).sendKeys("Admin");

        //Type password
        driver.findElement(new ByIdOrName("txtPassword")).sendKeys("Ptl@#321");

        //Click login button
        driver.findElement(new ByIdOrName("Submit")).click();

        //Verify the welcome message
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
    }


}
