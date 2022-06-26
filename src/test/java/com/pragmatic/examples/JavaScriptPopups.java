package com.pragmatic.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptPopups {


    //TODO 1
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://demosite.pragmatictestlabs.com");
        driver.findElement(By.id("btnalert")).click();
    }

   @Test
    public void testAlerts(){
        driver.findElement(By.xpath("//button[text() ='Simple Alert']")).click();
        String message = driver.switchTo().alert().getText();
        Assert.assertEquals(message, "This Is Simple Alert");
   }


}
