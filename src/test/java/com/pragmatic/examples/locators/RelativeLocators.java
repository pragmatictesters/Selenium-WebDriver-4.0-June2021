package com.pragmatic.examples.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * This example demonstrate the use of relative locators
 * https://www.selenium.dev/documentation/webdriver/elements/locators/
 */
public class RelativeLocators {

    @Test
    public void testRelativeLocatorAbove() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        By userNameLocator = with(By.tagName("input")).above(By.id("txtPassword"));
        driver.findElement(userNameLocator).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
        driver.quit();
    }

    @Test
    public void testRelativeLocatorBelow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        By passwordLocator = with(By.tagName("input")).below(By.id("txtUsername"));
        driver.findElement(passwordLocator).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
        driver.quit();
    }

    @Test
    public void testRelativeLocatorBelow2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        WebElement txtUsername = driver.findElement(By.id("txtUsername"));

        txtUsername.sendKeys("Admin");
        WebElement txtPassword = driver.findElement(with(By.tagName("input")).below(txtUsername));
        txtPassword.sendKeys("Ptl@#321");
        txtPassword.sendKeys(Keys.ENTER);
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
        driver.quit();
    }

    @Test
    public void testRelativeLocatorNear() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        By passwordLocator = with(By.tagName("input")).below(By.id("txtUsername"));
        driver.findElement(passwordLocator).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);

        new Actions(driver).moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).click(driver.findElement(By.id("menu_pim_addEmployee"))).perform();

        By txtFirstNameLocator = with(By.tagName("input")).below(By.xpath("//div[contains(text(),'First Name')]"));
        driver.findElement(txtFirstNameLocator).sendKeys("Janesh");
        // driver.quit();
    }

    @Test
    public void testRelativeLocatorRightOf() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        By passwordLocator = with(By.tagName("input")).below(By.id("txtUsername"));
        driver.findElement(passwordLocator).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);

        new Actions(driver).moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).click(driver.findElement(By.id("menu_pim_addEmployee"))).perform();

        By txtFirstNameLocator = with(By.tagName("input")).toRightOf(By.xpath("//label[contains(text(),'Full Name')]"));
        driver.findElement(txtFirstNameLocator).sendKeys("Janesh");
        // driver.quit();
    }


}
