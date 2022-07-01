package com.pragmatic.examples.locators;

import com.pragmatic.selenium.support.ByButtonText;
import com.pragmatic.selenium.support.ByPartialButtonText;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomLocatorsExample {

    private WebDriver driver;

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
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.findElement(By.id("btnalert")).click();
    }


    @Test
    public void testAlertByLocatingButtonWithText(){
        //Click the simple alert button
        //Locate the button by exact button text
        driver.findElement(new ByButtonText("Simple Alert")).click();

        //Switch to the alert
        Alert simpleAlert = driver.switchTo().alert();

        //Check the message
        Assert.assertEquals( simpleAlert.getText(), "This Is Simple Alert", "Alert message is not correct");

        //Click OK button
        simpleAlert.accept();

        //Check the message on the web page
        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), "Alert is gone.");
    }


    @Test
    public void testLocateButtonWithPartialText(){
        driver.findElement(new ByPartialButtonText("Confirm Alert")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!");
        driver.switchTo().alert().dismiss();
    }


}
