package com.pragmatic.examples.testng;

import org.testng.annotations.Test;

public class TestNGExample3 {


    @Test
    public void testMethod3(){
        System.out.println("TestNGExample1.testMethod3");
    }

    @Test
    public void testMethod1(){
        System.out.println("TestNGExample1.testMethod1");
    }

    @Test (invocationCount = 3)
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
