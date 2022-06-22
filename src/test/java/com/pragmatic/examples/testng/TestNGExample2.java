package com.pragmatic.examples.testng;

import org.testng.annotations.Test;

public class TestNGExample1 {


    @Test (priority = 2)
    public void testMethod3(){
        System.out.println("TestNGExample1.testMethod3");
    }

    @Test (priority = 1)
    public void testMethod1(){
        System.out.println("TestNGExample1.testMethod1");
    }

    @Test (priority = 3)
    public void testMethod2(){
        System.out.println("TestNGExample1.testMethod2");
    }
    

    @Test
    public void testMethod4(){
        System.out.println("TestNGExample1.testMethod4");
    }

    @Test
    public void testMethod5(){
        System.out.println("TestNGExample1.testMethod5");
    }



}
