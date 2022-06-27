package com.pragmatic.examples.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximizeBrowserWindow {

    @Test
    public void testChromeMaximizeBrowserWindow() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        //Maximize the window
        driver.manage().window().maximize();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
        driver.quit();
    }

     @Test
    public void testChromeMinimizeBrowserWindow() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        //Maximize the window
        driver.manage().window().minimize();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
        driver.quit();
    }



}
