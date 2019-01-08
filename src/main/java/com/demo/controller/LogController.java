package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);
    @RequestMapping("testlog")
    public void testLog(){
        logger.error("error testLog >>>>>>>>>>>>>>");
        logger.info("info testLog>>>>");
    }
}
