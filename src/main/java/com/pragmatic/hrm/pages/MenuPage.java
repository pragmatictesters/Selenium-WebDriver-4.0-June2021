package com.pragmatic.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    private final WebDriver driver;

    @FindBy(id = "welcome")
    private WebElement lnkWelcome;

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement mnuPIM;

    @FindBy(id = "menu_pim_addEmployee")
    private WebElement mnuAddEmployee;


    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getWelcomeMessage() {
        return lnkWelcome.getText();
    }

    public void navigateToAddEmployeePage() {
        mnuPIM.click();
        mnuAddEmployee.click();
    }
}
