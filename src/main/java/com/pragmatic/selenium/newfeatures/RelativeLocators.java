package com.pragmatic.selenium.newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RelativeLocators {

    @Test
    public void testBelow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        WebElement btnLoin = driver.findElement(with(with(By.id("txtUsername"))).below(By.tagName("button")) );
        
        btnLoin.click();

    }

}
