package com.pragmatic.examples.screenshots;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class ScreenshotExample {

    Faker faker;

    @BeforeClass
    public void beforeClas() throws IOException {
        faker = new Faker();
        FileUtils.deleteDirectory(new File("pics"));
    }

    @Test
    public void screenshotPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");

        //Take screenshot
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file
        FileUtils.copyFile(file, new File(String.format("pics/%s/login-page-%s.png", getMethodName(1), getTimeStamp())));

        driver.quit();
    }


    @Test
    public void screenShotElement() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();

        WebElement menuElement = driver.findElement(By.cssSelector("div.menu"));
        File file = menuElement.getScreenshotAs(OutputType.FILE);


        //Copy the file
        FileUtils.copyFile(file, new File(String.format("pics/%s/menu-%s.png", getMethodName(1),getTimeStamp())));
        driver.quit();
    }

    @Test
    public void screenShotElementHeadless() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();

        WebElement menuElement = driver.findElement(By.cssSelector("div.menu"));
        File file = menuElement.getScreenshotAs(OutputType.FILE);
        //Copy the file
        FileUtils.copyFile(file, new File(String.format("pics/%s/menu-%s.png", getMethodName(1), getTimeStamp())));
        driver.quit();
    }

    @Test
    public void testStackTrace(){
        System.out.println(Thread.currentThread().getStackTrace().toString());
        System.out.println(getMethodName(1));
        System.out.println(getMethodName(0));
        System.out.println(getMethodName(3));
    }

    private String getMethodName(int x) {
        return Thread.currentThread().getStackTrace()[x].getMethodName();
    }

    private String getTimeStamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        return formattedDate;
    }


}
