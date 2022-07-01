package com.pragmatic.selenium.support;

import org.openqa.selenium.WebDriverException;

public class UnexpectedCheckboxException extends WebDriverException {

    public UnexpectedCheckboxException(String tagName, String typeName){
        super(String.format("Element is not a checkbox. " +
                "\n Expected input as tagName but was %s " +
                "\n Expected type name as checkbox but was %s", tagName, typeName));
    }

}
