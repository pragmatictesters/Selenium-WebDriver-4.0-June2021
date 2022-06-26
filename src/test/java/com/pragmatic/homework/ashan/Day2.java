package com.pragmatic.homework.ashan;

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
import org.testng.annotations.Test;

import java.time.Duration;

public class Day2 {
    WebDriver Driver;

    @BeforeClass
    public void DriverInitialization()
    {
        WebDriverManager.chromedriver().setup();
        Driver=new ChromeDriver();
        Driver.navigate().to("http://www.demosite.pragmatictestlabs.com/");
    }

    @AfterClass
    public void closeItems()
    {
        //Driver.close();
    }


    @Test
    public void navigatetoAlerts()
    {
        Driver.findElement(By.id("btnalert")).click();
    }

    //Find element by Xpath using Event
    @Test
    public void callSimpleAlert()
    {
        Driver.findElement(By.id("btnalert")).click();
        Driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
        Driver.switchTo().alert().accept();
        System.out.println("Output is: " + Driver.findElement(By.id("confirm-demo")).getText());
        Assert.assertEquals(Driver.findElement(By.id("confirm-demo")).getText(),"Alert is gone.");
        Driver.navigate().back();
    }

    //Find element by Xpath using Contains
    @Test
    public void callConfirmAlertAccept()
    {
        //Alert Accept
        Driver.findElement(By.id("btnalert")).click();
        Driver.findElement(By.xpath("//button[contains(text(),' Confirm Alert')]")).click();
        Driver.switchTo().alert().accept();
        System.out.println("Output is: "+Driver.findElement(By.id("confirm-demo")).getText());
        Assert.assertEquals(Driver.findElement(By.id("confirm-demo")).getText(),"Confirmed.");
        Driver.navigate().back();


    }

    //Find element by Xpath using starts-with - Reject click
    @Test
    public void callConfirmAlertReject()
    {
        //Alert Reject
        Driver.findElement(By.id("btnalert")).click();
        Driver.findElement(By.xpath("//button[starts-with(text(),' Confirm')]")).click();
        Driver.switchTo().alert().dismiss();
        System.out.println("Output is: "+Driver.findElement(By.id("confirm-demo")).getText());
        Assert.assertEquals(Driver.findElement(By.id("confirm-demo")).getText(),"Rejected!");
        Driver.navigate().back();
    }

    //Find element by Xpath using Contains - Prompt Alert Accept
    @Test
    public void callAlertPromptAccept()
    {
        //Alert Reject
        Driver.findElement(By.id("btnalert")).click();
        Driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();
        Alert promptAlert= Driver.switchTo().alert();
        promptAlert.sendKeys("Ashan");
        promptAlert.accept();
        System.out.println("Output is: "+Driver.findElement(By.id("confirm-demo")).getText());
        Assert.assertEquals(Driver.findElement(By.id("confirm-demo")).getText(),"Ashan");
        Driver.navigate().back();
    }

    //Find element by Xpath using Contains - Prompt Alert Reject
    @Test
    public void callAlertPromptReject()
    {
        //Alert Reject
        Driver.findElement(By.id("btnalert")).click();
        String strCurrentText=Driver.findElement(By.id("confirm-demo")).getText();
        Driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();
        System.out.println("Label contains = "+strCurrentText);
        Alert promptAlert= Driver.switchTo().alert();
        promptAlert.sendKeys("Ashan");
        promptAlert.dismiss();
        System.out.println("Output is: "+Driver.findElement(By.id("confirm-demo")).getText());
        Assert.assertEquals(Driver.findElement(By.id("confirm-demo")).getText(),strCurrentText);
        Driver.navigate().back();
    }

    //Find element by Xpath using Contains - Timing Alert Accept
    @Test
    public void callAlertTimingAccept() throws InterruptedException {
        //Alert Reject
        Driver.findElement(By.id("btnalert")).click();
        Driver.findElement(By.xpath("//button[contains(text(),'Timing Alert')]")).click();
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert= Driver.switchTo().alert();
        String strGetText=promptAlert.getText();
        promptAlert.dismiss();
        System.out.println("Output is: "+strGetText);
        Assert.assertEquals(strGetText,"This is Timing Alert");
        Driver.navigate().back();
    }
}
