package com.pragmatic.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage {
    private final WebDriver driver  ;

    @FindBy(id="personal_txtEmpFirstName")
    private WebElement txtUserName;

    @FindBy(id="personal_txtEmpLastName")
    private WebElement txtLastname;



    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstName() {
        return txtUserName.getAttribute("value");
    }

   public String getLastName() {
        return txtLastname.getAttribute("value");
    }



}
