package com.pragmatic.selenium.tests;

import com.pragmatic.selenium.TestBase;
import com.pragmatic.selenium.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://hrm.pragmatictestlabs.com");


    }


    @Test
    public void testLoginWithBlankUsernameAndBlankPassword(){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("").typePassword("").clickLogin();
        Assert.assertEquals(loginPage.getError(), "Username cannot be empty");

    }
}
