package com.pragmatic.examples.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This example demonstrate the use of soft asserts in TestNG
 *
 */
public class TestNGSoftAssertExample {


    @Test
    public void testFailedAssert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 1);
        softAssert.assertEquals(1, 2);
        softAssert.assertTrue(true);
        softAssert.assertTrue(false);
        softAssert.assertFalse(true);
        softAssert.assertFalse(false);
        softAssert.assertAll("At least one assertion failed");

    }

    @Test
    public void testPassedAssert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 1);
        softAssert.assertTrue(true);
        softAssert.assertFalse(false);
        softAssert.assertAll("At least one assertion failed");

    }
}
