package com.pragmatic.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {
    private final WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement txtFirstName;

    @FindBy(id = "lastName")
    private WebElement txtLastName;

    @FindBy(id = "btnSave")
    private WebElement btnSave;


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddEmployeePage typeFirstName(String firstName) {
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
        return this;
    }

    public AddEmployeePage typeLastName(String lastName) {
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
        return this;
    }

    public void clickSave() {
        btnSave.click();
    }
}
