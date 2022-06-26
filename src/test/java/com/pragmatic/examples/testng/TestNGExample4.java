package com.pragmatic.examples.testng;

import org.testng.annotations.Test;

public class TestNGExample4 {


    @Test
    public void testMethod3(){
        System.out.println("TestNGExample1.testMethod3");
    }

    @Test
    public void testMethod1(){
        System.out.println("TestNGExample1.testMethod1");
    }

    @Test(timeOut = 1000)
    public void testMethod2() throws InterruptedException {
        System.out.println("TestNGExample1.testMethod2");
        Thread.sleep(2000);
    }
    

    @Test(enabled = false)
    public void testMethod4(){
        System.out.println("TestNGExample1.testMethod4");
    }

    @Test
    public void testMethod5(){
        System.out.println("TestNGExample1.testMethod5");
    }



}
