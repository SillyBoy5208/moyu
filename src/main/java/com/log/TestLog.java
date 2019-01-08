package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
    private static Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) throws Exception{
        while (true){
            logger.error("test>>>>>>>>>>>>>>>>");
            Thread.sleep(1000);
        }
    }
}
