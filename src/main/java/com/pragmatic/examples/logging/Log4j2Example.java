package com.pragmatic.examples.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4j2Example {


     private  static Logger logger = LogManager.getLogger();


     @Test
    public void testMethod1(){
         logger.trace("I am a trace message ");
         logger.debug("I am a debug message ");
         logger.info("I am a info message ");
         logger.warn("I am a warn message ");
         logger.error("I am a error message ");
         logger.fatal("I am a fatal message ");
     }
}
