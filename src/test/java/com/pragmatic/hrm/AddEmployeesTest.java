package com.pragmatic.hrm;

import com.github.javafaker.Faker;
import com.pragmatic.selenium.support.Check;
import com.pragmatic.selenium.support.UnexpectedCheckbox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

public class AddEmployeesTest {

    private WebDriver driver;
    private Faker faker;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        faker = new Faker();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://hrm.pragmatictestlabs.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);

        //Move to element and click add employee link
        Actions actions1= new Actions(driver);
        actions1.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule")))
                .click(driver.findElement(By.id("menu_pim_addEmployee")))
                .build()
                .perform();
//        driver.findElement(By.id("menu_pim_viewPimModule")).click();
//        driver.findElement(By.id("menu_pim_addEmployee")).click();
    }

    /**
     * Add a new employee with mandatory information (first name and last name)
     */
    @Test
    public void testAddNewEmployeeWithMandatoryInformation() {
        String lastName = faker.name().lastName();
        String firstName = faker.name().firstName();
        //Type firstname
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        //Type lastname
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        //Click Save button
        driver.findElement(By.id("btnSave")).click();
        //Assert success
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), firstName);
    }

    /**
     * Create a new employee with a profile picture
     */
    @Test
    public void testAddNewEmployeeWithMandatoryInformationAndProfilePicture() {
        String lastName = faker.name().lastName();
        String firstName = faker.name().firstName();
        //Type firstname
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        //Type lastname
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        //Upload profile picture
        driver.findElement(By.id("photofile")).sendKeys(System.getProperty("user.dir") + "/testdata/emp-pic.png");

        //Click Save button
        driver.findElement(By.id("btnSave")).click();

        //Assert success
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), firstName);
    }


    /**
     * Create a new employee with login credentials - enabled
     */
    @Test
    public void testAddNewEmployeeWithLoginCredentialsEnabled() throws UnexpectedCheckbox {
        String lastName = faker.name().lastName();
        String firstName = faker.name().firstName();
        //Type firstname
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        //Type lastname
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        WebElement checkboxElement = driver.findElement(By.id("chkLogin"));

        Check checkbox = new Check(checkboxElement);

        checkbox.check(); //Click the checkbox

        driver.findElement(By.id("user_name")).sendKeys(String.format("%s.%s", firstName, lastName));
        driver.findElement(By.id("user_password")).sendKeys("Ptl@#321");
        driver.findElement(By.id("re_password")).sendKeys("Ptl@#321");

        //Selecting an item from a list box or dropdown
        Select lstStatus = new Select(driver.findElement(By.id("status")));
        lstStatus.selectByVisibleText("Enabled");

        //Click Save button
        driver.findElement(By.id("btnSave")).click();


        //Assert success
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"), firstName);


        //Login and check the new user can log in to the system

    }


}
