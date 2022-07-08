package com.pragmatic.examples.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ByChainedExample {


    @Test
    public void exampleByChained() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        //driver.findElement(new ByChained(By.id("frmLogin"), By.className("textInputContainer"), By.name("txtUsername"))).sendKeys("Admin");
        driver.findElement(new ByChained(By.id("frmLogin"), By.className("textInputContainer"), By.tagName("input"))).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
        driver.quit();
    }
}
