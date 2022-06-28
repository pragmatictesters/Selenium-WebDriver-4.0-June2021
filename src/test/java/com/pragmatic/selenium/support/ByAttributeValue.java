package com.pragmatic.selenium.support;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByAttributeValue extends By {
    private final String attributeName;
    private final String attributeValue;

    public ByAttributeValue(String attributeName, String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.cssSelector(String.format("[%s='%s']", this.attributeName, this.attributeValue)));
    }
}
