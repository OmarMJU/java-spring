package com.omju.springboot.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigPropertiesBeanImpl implements ConfigPropertiesBean {
    private static final Logger LOGGER = LogManager.getLogger(ConfigPropertiesBeanImpl.class);
    private static final String SPACE = " ";
    private final String lastName;
    private final String random;
    private final String name;

    public ConfigPropertiesBeanImpl(String lastName, String name, String random) {
        this.lastName = lastName;
        this.name = name;
        this.random = random;
    }

    @Override
    public void functionConfig() {
        LOGGER.info("The name in the properties file is {} and the random value is {}", this.name + SPACE + this.lastName, this.random);
    }
}
