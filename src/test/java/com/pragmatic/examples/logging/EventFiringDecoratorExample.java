package com.pragmatic.examples.logging;

import com.pragmatic.selenium.support.CustomListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 */
public class EventFiringDecoratorExample {


    @Test
    public void exampleEventFiringWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverListener listener = new CustomListener();
        WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);

        decorated.get("http://hrm.pragmatictestlabs.com");
        decorated.findElement(By.id("txtUsername")).sendKeys("Admin");
        decorated.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        decorated.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
        String welcomeMessage = decorated.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
        driver.quit();
    }
}
