package com.pragmatic.examples.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ByAllExample {


    @Test
    public void exampleByChained() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        List<WebElement> elements = driver.findElements(new ByAll(By.id("txtUsername"), By.name("txtPassword")));
        Assert.assertEquals(elements.size(),2);
        driver.quit();
    }
}
