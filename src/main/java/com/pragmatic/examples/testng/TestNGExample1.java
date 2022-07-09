package com.pragmatic.examples.testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample1 {



    @Test (priority = 2, groups = {"smoke", "regression"})
    public void testMethod3(){
        System.out.println("TestNGExample1.testMethod3");
    }

    @Test (priority = 1, groups = { "regression"})
    public void testMethod1(){
        System.out.println("TestNGExample1.testMethod1");
    }

    @Test (priority = 3 , groups = { "regression"})
    public void testMethod2(){
        System.out.println("TestNGExample1.testMethod2");
    }


    @Test(groups = { "regression"})
    public void testMethod4(){
        System.out.println("TestNGExample1.testMethod4");
    }

    @Test(groups = { "regression"})
    public void testMethod5(){
        System.out.println("TestNGExample1.testMethod5");
    }



}
