package com.pragmatic.selenium.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomListener implements WebDriverListener {

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("url = " + url);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println("result = " + result);
    }

}
