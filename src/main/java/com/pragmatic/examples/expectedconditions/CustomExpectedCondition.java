package com.pragmatic.examples.expectedconditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CustomExpectedCondition {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void testMethod() {
        Actions actions = new Actions(driver);
        WebElement collapsableElement = driver.findElement(By.id("collapsable"));
        System.out.println("Before " + collapsableElement.getSize().height);
        actions.moveToElement(collapsableElement).perform();

        WebElement link = driver.findElement(By.id("aboutlink"));

        wait.until(new ElementFullyExpanded(By.id("collapsable")));
        link.click();
    }

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://eviltester.github.io/synchole/collapseable.html");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    private class ElementFullyExpanded  implements ExpectedCondition<Boolean> {
        private final By elementBy;
        private int lastHeight;

        public ElementFullyExpanded(By elementBy) {
            this.elementBy= elementBy;
        }

        @Override
        public Boolean apply(WebDriver webDriver) {
            int newHeight = webDriver.findElement(elementBy).getSize().height;
            if (newHeight > lastHeight){
                System.out.println(String.format("%s > %s ", newHeight, lastHeight ));
                lastHeight = webDriver.findElement(elementBy).getSize().height;
                return false;
            } else {
                System.out.println(String.format("Fully expanded %s and  %s ", newHeight, lastHeight ));
                return  true;
            }
        }
    }
}
