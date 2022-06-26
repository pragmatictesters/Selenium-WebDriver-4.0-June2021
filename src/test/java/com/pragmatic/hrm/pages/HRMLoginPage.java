package com.pragmatic.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMLoginPage {

    //Define the elements for the page
    private WebDriver driver;

    //Username element
    @FindBy(id = "txtUsername")
    WebElement txtUsername;

    //Password element\
    @FindBy(id = "txtPassword")
    WebElement txtPassword;


    //Login button
    @FindBy(id = "btnLogin")
    WebElement btnLogin;

    //Error message
    @FindBy(id = "spanMessage")
    WebElement msgError;

    public HRMLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this); //Magic code line
    }

    public HRMLoginPage typeUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
        return this;
    }

    public HRMLoginPage typePassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String getError() {
        return msgError.getText();
    }
}
