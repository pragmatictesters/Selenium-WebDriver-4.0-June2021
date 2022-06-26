package com.pragmatic.homework.ashan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Day1 {

    public static final By byUsername = By.id("txtUsername");
    //declaration
    WebDriver driver;
    String arrInforMsg[] = new String[5];

    //Before class ececutions
    @BeforeClass
    public void initialization() {
        //Set up the browser driver
        WebDriverManager.chromedriver().setup();

        // Fill information massages to a array
        arrInforMsg[0] = "Username cannot be empty";
        arrInforMsg[1] = "Password cannot be empty";
        arrInforMsg[2] = "Invalid credentials";
        arrInforMsg[3] = "";
        arrInforMsg[4] = "";

    }

    private String rtnArrayEliment(int arrId) {
        return arrInforMsg[arrId];
    }

    //After class executions
    @AfterClass
    public void afterclassExecutions() {
        //driver.close();
    }

    @BeforeMethod
    public void beforeMethodExecutions() {
        //Access the web page
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com/");
    }

    @AfterMethod
    public void afterMethodExecutions() {
        driver.close();
    }

    //Login with correct credintials
    @Test(priority = 1)
    public void testLoginwithcorrectCredintials() throws InterruptedException {
        //input user name
        driver.findElement(byUsername).sendKeys("Admin");

        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //Check login button status
        Boolean btnLoginStatus = false;
        btnLoginStatus = driver.findElement(By.id("btnLogin")).isEnabled();

        //Click login button
        if (btnLoginStatus == true) {
            driver.findElement(By.id("btnLogin")).click();
            //Assert.assertTrue(driver.findElement(By.id("btnLogin")).isEnabled());

        } else {
            Assert.assertFalse(driver.findElement(By.id("btnLogin")).isEnabled());
        }



        String strCurrentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is 00 " + strCurrentUrl);

        Assert.assertEquals(strCurrentUrl, "http://hrm.pragmatictestlabs.com/symfony/web/index.php/dashboard");
        if (strCurrentUrl.equals("http://hrm.pragmatictestlabs.com/symfony/web/index.php/dashboard")) {
            Assert.assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
            System.out.println("Current URL is 01 " + strCurrentUrl);
            driver.findElement(By.partialLinkText("Admin")).click();

            //driver.findElement(By.partialLinkText("welcome")).click();;
            System.out.println("Current URL is 02 " + strCurrentUrl);
            driver.findElement(By.partialLinkText("Adm"));
            //Thread.sleep(100);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout"))).click();
            //driver.findElement(By.linkText("Logout")).click();
            System.out.println("Current URL is 03 " + strCurrentUrl);
            Thread.sleep(1000);
        }

    }

    //Login with blank user name and password
    @Test(priority = 2)
    public void testLoginwithBlankUserIdandPassword() {
        //input user name
        driver.findElement(byUsername).clear();

        //input Password
        driver.findElement(By.id("txtPassword")).clear();

        //Click login button
        driver.findElement(By.id("btnLogin")).click();
    }

    //Login with Wrong user name and password
    @Test(priority = 3)
    public void testLoginwithWrongUserIdandPassword() {
        //input user name
        driver.findElement(byUsername).sendKeys("Ashan");

        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Abc123");

        //Click login button
        driver.findElement(By.id("btnLogin")).click();
    }

    //Login with correct user id with blank password
    @Test(priority = 4)
    public void testLoginwithCorrectUserIdWithBlankPassword() {
        //input user name
        driver.findElement(byUsername).sendKeys("Admin");

        //input Password
        driver.findElement(By.id("txtPassword")).clear();

        //Click login button
        driver.findElement(By.id("btnLogin")).click();
    }

    //Login with correct user id with wrong password
    @Test(priority = 5)
    public void testLoginwithCorrectUserIdWithWrongPassword() {
        //input user name
        driver.findElement(byUsername).sendKeys("Admin");

        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Abc123");

        //Click login button
        driver.findElement(By.id("btnLogin")).click();
    }

    //Login with correct password with blank user id
    @Test(priority = 6)
    public void testLoginwithCorrectPasswordWithBlankUserID() {
        //input user name
        driver.findElement(byUsername).clear();

        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //Click login button
        driver.findElement(By.id("btnLogin")).click();
    }

    //Login with correct password with wrong user id

    /**
     * Verify user login with correct password and invalid  username
     */
    @Test(priority = 7)
    public void testLoginwithCorrectPasswordWithWrongUserId() {
        //input user name
        driver.findElement(byUsername).sendKeys("Ashan");

        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //Click login button
        driver.findElement(By.id("btnLogin")).click();
    }

    //Login with SQL Injections
    @Test(priority = 8)
    public void testLoginwithSQLInjections() {
        //input user name
        driver.findElement(byUsername).sendKeys("Ad'min");

        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //Click login button
        driver.findElement(By.id("btnLogin")).click();
    }

    //Login with correct credintials with enter key
    @Test(priority = 9)
    public void testLoginwithcorrectCredintialswithenterkey() {
        //input user name
        driver.findElement(byUsername).sendKeys("Admin");

        //input Password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        //Press enter key
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
    }
}
