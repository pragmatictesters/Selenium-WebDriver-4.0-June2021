package com.pragmatic.hrm;

import com.pragmatic.selenium.support.Button;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.close();
    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver.get("http://hrm.pragmatictestlabs.com");
    }


    @Test(groups = {"smoke", "regression"})
    public void testLoginWithValidCredentials() throws InterruptedException {
        //Type username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //Proceed only if the button is enabled. Else fail the cases
        WebElement loginButton = driver.findElement(By.id("btnLogin"));

        Assert.assertTrue(loginButton.isEnabled());

        //Click login button
        driver.findElement(By.id("btnLogin")).click();

        //Verify if user has logged into the system e.g check welcome message
//        Thread.sleep(10000); //NOT efficient. NEVER USE

        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
    }

 @Test()
    public void testLoginWithValidCredentialsWithButtonSupportClass()  {
        //Type username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //Type password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");

        //Proceed only if the button is enabled. Else fail the cases
        WebElement loginButtonElement = driver.findElement(By.id("btnLogin"));

     Button loginButton = new Button(loginButtonElement);

        Assert.assertTrue(loginButton.isEnabled());

        //Click login button
        loginButton.click();

        //Verify if user has logged into the system e.g check welcome message
//        Thread.sleep(10000); //NOT efficient. NEVER USE

        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
    }

    @Test(groups = {"regression"})
    public void testLoginWithBlankUsernameAndBlankPassword() {
        driver.findElement(By.name("txtUsername")).clear();
        driver.findElement(By.name("txtPassword")).clear();
        driver.findElement(By.name("txtPassword")).sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");
    }

    @Test
    public void testLoginWithBlankPassword() {
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).clear();
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Password cannot be empty");
    }

    @Test(dataProvider = "login-inputs", dataProviderClass = com.pragmatic.hrm.HRMData.class)
    public void testLoginValidationTests(String username, String password, String expectedOutcome) {
        driver.findElement(By.name("txtUsername")).sendKeys(username);
        driver.findElement(By.name("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), expectedOutcome);
    }


    @Test
    public void testLoginInvalidPassword() {
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("Invalid");
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Invalid credentials");
    }

    @Test(dataProvider = "data-provider-login-inputs", dataProviderClass = com.pragmatic.hrm.TestData.class)
    public void testLoginWithInvalidInputData(String username, String password, String expectedOutcome) {
        driver.findElement(By.name("txtUsername")).sendKeys(username);
        driver.findElement(By.name("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), expectedOutcome);
    }


    @Test
    public void testLogout() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("welcome")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout"))).click();


    }

    @Test
    public void testLogoutWithImplicitWait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //NOT RECOMMENDED
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void testLogoutWithSleep() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(1000); //NOT A GOOD SOLUTION
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void testLogoutWithActions() throws InterruptedException {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.id("welcome"))).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        actions.pause(Duration.ofSeconds(1))
                .click(driver.findElement(By.linkText("Logout")))
                .build()
                .perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

}
