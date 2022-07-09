package com.pragmatic.hrm.tests;

import com.pragmatic.hrm.HRMBase;
import com.pragmatic.hrm.pages.HRMLoginPage;
import com.pragmatic.hrm.pages.MenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends HRMBase {


    private Logger logger = LogManager.getLogger();

    @Test
    public void testValidUserLogin(){
        logger.trace("I am from Login test ");
        logger.debug("I am from Login test ");
        logger.info("I am from Login test ");
        logger.warn("I am from Login test ");
        logger.error("I am from Login test ");
        logger.fatal("I am from Login test ");

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
