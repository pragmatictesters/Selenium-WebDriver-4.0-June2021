package com.pragmatic.examples.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScreenshotExample {


    @Test
    public void exampleByChained() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        List<WebElement> elements = driver.findElements(new ByAll(By.id("txtUsername"), By.name("txtPassword")));
        Assert.assertEquals(elements.size(),2);

        //Take screenshot
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file
        FileUtils.copyFile(file, new File("pics/login-page.png"));

        driver.quit();
    }
}
