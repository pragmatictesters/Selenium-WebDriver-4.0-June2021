package com.pragmatic.examples.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JExample {

    private static Logger logger = LogManager.getLogger();

    /**
     *
     * Lo
     *
     * @param args
     */
    public static void main(String[] args) {
        logger.trace("It is a trace logger.");
        logger.debug("It is a debug logger.");
        logger.info("It is a info logger.");
        logger.warn("It is a warn logger.");
        logger.error("It is an error logger.");
        logger.fatal("It is a fatal logger.");
     }
}
