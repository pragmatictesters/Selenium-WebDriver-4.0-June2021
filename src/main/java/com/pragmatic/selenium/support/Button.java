package com.pragmatic.selenium.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Button implements IButton, WrapsElement {
    private final WebElement button;

    public Button(WebElement button) {
        this.button = button;
    }

    @Override
    public WebElement getWrappedElement() {
        return button;
    }

    public boolean isEnabled() {
        return  button.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return button.isDisplayed();
    }

    @Override
    public String getText() {
        return button.getText();
    }

    public void click() {
        button.click();
    }
}
