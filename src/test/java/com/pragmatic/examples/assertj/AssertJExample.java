package com.pragmatic.examples.assertj;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJExample {

    @Test
    public void assertJExample() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.findElement(By.id("btndrag")).click();
        Actions actions = new Actions(driver);
        WebElement sourceElement = driver.findElement(By.id("draggableview"));
        WebElement targetElement = driver.findElement(By.id("droppableview"));
        actions.dragAndDrop(sourceElement, targetElement).perform();
        assertThat(targetElement.findElement(By.tagName("p")).getText()).isEqualTo("Dropped!");
        assertThat(targetElement.findElement(By.tagName("p")).getText()).containsIgnoringCase("dropped");
        driver.quit();
    }
}
