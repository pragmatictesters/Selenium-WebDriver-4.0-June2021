package com.pragmatic.examples.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TakeScreenshotExample {


    public static final String BASE_URL = "http://hrm.pragmatictestlabs.com/";

    @BeforeClass
    public void beforeClass() throws IOException {
        WebDriverManager.chromedriver().setup();
        FileUtils.deleteDirectory(new File("screenshots"));
    }


    @Test
    public void takeElementScreenshot() throws IOException {
        System.out.println("TakeScreenshotExample.takeElementScreenshot");
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        System.out.println("Value in element is " + driver.findElement(By.id("txtUsername")).getAttribute("value"));
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();

        WebElement menuElement = driver.findElement(By.cssSelector("div.menu"));
        //Taking screenshot to a File
        takeElementScreenshot(menuElement, "menu");
        driver.quit();
        System.out.println("Test is completed ");

    }

    @Test
    public void takeFullPageScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();

        //Take full screenshot
        takeFullScreenshot(driver, "landing-page");
        driver.quit();
    }


    @Test
    public void takeFullPageScreenshotHeadless() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();

        //Take full screenshot
        takeFullScreenshot(driver, "landing-page-headless");
        driver.quit();
    }

    private void takeFullScreenshot(WebDriver driver, String fileNamePrefix) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(String.format("screenshots/%s/" + fileNamePrefix + "-%s.png"
                , getTestMethodName(2), getTimestampForFileNames())));
    }

    private void takeElementScreenshot(WebElement menuElement, String fileNamePrefix) throws IOException {
        //TODO introduce timestamp into the filename
        //TODO introduce a folder with test method name
        File srcFile = menuElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(String.format("screenshots/%s/" + fileNamePrefix + "-%s.png",
                getTestMethodName(2),
                getTimestampForFileNames())));
    }

    public String getTimestampForFileNames(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        return formattedDate;
    }


    public String getTestMethodName(int x){
        return Thread.currentThread().getStackTrace()[x].getMethodName();
    }

}
