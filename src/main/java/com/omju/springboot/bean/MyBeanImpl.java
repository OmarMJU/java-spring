package com.omju.springboot.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBeanImpl implements MyBean {
    private static final Logger LOGGER = LogManager.getLogger(MyBeanImpl.class);

    @Override
    public void print() {
        LOGGER.info("My implementation from MyBean 😎");
    }

    @Override
    public void displayName(String name) {
        LOGGER.info("The name given is {}", name);
    }
}
