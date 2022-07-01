package com.pragmatic.selenium.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class ButtonPragmatic implements IButton, WrapsElement {
    private final WebElement button;

    public ButtonPragmatic(WebElement button) {
        this.button = button;
    }

    @Override
    public WebElement getWrappedElement() {
        return button;
    }

    public boolean isEnabled() {
        return button.isEnabled();

    }

    @Override
    public boolean isDisplayed() {
        return button.isDisplayed();
    }

    @Override
    public String getText() {
        String buttonLabel;

        if (button.getText().length()>0){
            buttonLabel = button.getText();
        } else {
            buttonLabel= button.getAttribute("value");
        }
        return buttonLabel;
    }

    public void click() {
        button.click();
    }
}
