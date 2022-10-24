package com.omju.springboot;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSpring {
    private static final Logger LOGGER = LogManager.getLogger(AppSpring.class);

    public static void main(String[] args) {
        LOGGER.info("Spring boot app... Start!!!");
        SpringApplication.run(AppSpring.class, args);
    }
}