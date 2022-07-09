package com.pragmatic.selenium.support;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByButtonText extends By {
    private final String buttonText;

    public ByButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.xpath(String.format("//button[text()='%s']",this.buttonText )));
        //return context.findElements(By.xpath(String.format("//span[@class='dx-button-text'][text()='%s']",this.buttonText )));
    }
}
