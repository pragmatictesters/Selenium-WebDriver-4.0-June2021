package com.pragmatic.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelloSelenium {


//
//    public static void main(String[] args) {
//        //Download or setup browser driver (Chrome)
//        WebDriverManager.chromedriver().setup();
//
//        //Open an instance of Chrome
//        WebDriver driver = new ChromeDriver();
//
//
//        //Navigate to the login page
//        driver.get("http://hrm.pragmatictestlabs.com");
//
//        //Interact with the page
//
//        //Check content
//
//        //Close the browser
//        driver.close();
//
//    }

    @Test
    public void helloSelenium(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.close();

    }





}
