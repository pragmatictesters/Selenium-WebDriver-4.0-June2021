package com.pragmatic.selenium.support;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByPartialButtonText extends By {
    private final String partialText;

    public ByPartialButtonText(String partialText) {
        this.partialText = partialText;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.xpath(String.format("//button[contains(text(),'%s')]", partialText)));
    }
}
