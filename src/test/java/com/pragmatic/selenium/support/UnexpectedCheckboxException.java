package com.pragmatic.selenium.support;

import org.openqa.selenium.WebDriverException;

public class UnexpectedCheckboxException extends WebDriverException {

    public UnexpectedCheckboxException(){
        super("Element is not a checkbox");
    }

}
