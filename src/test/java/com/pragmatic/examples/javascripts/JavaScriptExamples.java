package com.pragmatic.examples.javascripts;

import com.pragmatic.selenium.support.ByButtonText;
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

public class JavaScriptExamples {

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
    public void testAlert(){
        //Click the simple alert button
        driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();

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
    public void testConfirmationTestMessage(){
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Alert')]")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!");
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void testConfirmationOK(){
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Alert')]")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), "Confirmed.");
    }

    @Test
    public void testConfirmationCancel(){
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Alert')]")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), "Rejected!");
    }

    @Test
    public void testPrompt(){
        String name = "Selenium";
        driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("confirm-demo")).getText(), name);
    }

    @Test
    public void testTimingAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Timing Alert')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }



}
