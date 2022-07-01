package com.pragmatic.selenium.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Check implements ICheckbox, WrapsElement {
    private  WebElement checkboxElement;

    public Check(WebElement checkboxElement) throws UnexpectedCheckboxException {
        this.checkboxElement = null;
        //Should do a validation
        String typeName = checkboxElement.getAttribute("type");
        String tagName = checkboxElement.getTagName();
        if(typeName.equalsIgnoreCase("checkbox")) {
            this.checkboxElement= checkboxElement;
        } else  {
            throw new UnexpectedCheckboxException();
        }


    }

    @Override
    public boolean isEnabled() {
        return checkboxElement.isEnabled();
    }

    @Override
    public boolean isChecked() {
        return checkboxElement.isSelected();
    }

    @Override
    public boolean isFocused() {
        return checkboxElement.isSelected();
    }

    @Override
    public void check() {
        if (!isChecked()){
            checkboxElement.click();
        }

    }

    @Override
    public void uncheck() {
        if (isChecked()){
            checkboxElement.click();
        }
    }

    @Override
    public WebElement getWrappedElement() {
        return checkboxElement;
    }
}
