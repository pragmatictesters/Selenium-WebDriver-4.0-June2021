package com.pragmatic.hrm.tests;

import com.pragmatic.hrm.HRMBase;
import com.pragmatic.hrm.pages.HRMLoginPage;
import com.pragmatic.hrm.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends HRMBase {



    @Test
    public void testValidUserLogin(){
        HRMLoginPage loginPage = new HRMLoginPage(driver);
        driver.get("http://hrm.pragmatictestlabs.com");
        loginPage.typeUsername("Admin").typePassword("Ptl@#321").clickLogin();
        MenuPage menuPage = new MenuPage(driver);
        Assert.assertEquals(menuPage.getWelcomeMessage(), "Welcome Admin");
    }

     @Test
    public void testBlankUsernameAndBlankPassword(){
        HRMLoginPage loginPage = new HRMLoginPage(driver);
        driver.get("http://hrm.pragmatictestlabs.com");
        loginPage.typeUsername("").typePassword("").clickLogin();
        Assert.assertEquals(loginPage.getError(), "Username cannot be empty");
    }




}
