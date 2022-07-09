package com.pragmatic.hrm.tests;

import com.github.javafaker.Faker;
import com.pragmatic.hrm.HRMBase;
import com.pragmatic.hrm.pages.AddEmployeePage;
import com.pragmatic.hrm.pages.MenuPage;
import com.pragmatic.hrm.pages.PersonalInformationPage;
import com.pragmatic.selenium.pages.LoginPage;
import com.pragmatic.util.RandomData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewEmployeeTest extends HRMBase {


    public static final String BASE_URL = "http://hrm.pragmatictestlabs.com";
    public static final String PASSWORD = "Ptl@#321";
    public static final String USERNAME = "Admin";

    Faker faker ;

    @BeforeClass
    public void beforeClass(){
        faker = new Faker();
        driver.get(BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);
    }


    @BeforeMethod
    public void beforeMethod(){
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToAddEmployeePage();
    }


    @Test()
    public void addEmployeeWithMandatoryInformation() {
        String firstName = RandomData.getFirstName();
        String lastName = faker.name().lastName();


        System.out.println("AddNewEmployeeTest.addEmployeeWithMandatoryInformation");
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage.typeFirstName(firstName).typeLastName(lastName).clickSave();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        Assert.assertEquals(personalInformationPage.getFirstName(), firstName);
        Assert.assertEquals(personalInformationPage.getLastName(), lastName);

    }




    @Test(enabled = false)
    public void addEmployeeWithFullInformation() {

    }

    @Test(enabled = false)
    public void addEmployeeWithUserCredentialsEnabled() {


    }


    @Test(enabled = false)
    public void addEmployeeWithUserCredentialsDisbled() {

    }


}
