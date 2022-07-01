package com.pragmatic.examples.draganddrop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DragAndDropExample {


    @Test
    public void dragAndDropExample() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.findElement(By.id("btndrag")).click();

        Actions actions = new Actions(driver);
        WebElement sourceElement = driver.findElement(By.id("draggableview"));
        WebElement targetElement = driver.findElement(By.id("droppableview"));
        actions.dragAndDrop(sourceElement, targetElement).perform();
        Assert.assertEquals(targetElement.findElement(By.tagName("p")).getText(), "Dropped!");
        driver.quit();
    }
}
