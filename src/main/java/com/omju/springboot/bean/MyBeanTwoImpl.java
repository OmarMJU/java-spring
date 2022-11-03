package com.omju.springboot.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBeanTwoImpl implements MyBean {
    private static final Logger LOGGER = LogManager.getLogger(MyBeanTwoImpl.class);

    @Override
    public void print() {
        LOGGER.info("My implementation from... other MyBean 🤩");
    }

    @Override
    public void displayName(String name) {
        LOGGER.info("My name is {}", name);
    }
}
