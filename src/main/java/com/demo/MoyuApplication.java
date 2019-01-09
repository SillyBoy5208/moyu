package com.demo;

import com.demo.config.WebConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan({"com.demo.mapper"})
@Import(WebConfig.class)
public class MoyuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoyuApplication.class, args);
    }

}

