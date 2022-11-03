package com.omju.springboot.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency {
    private static final Logger LOGGER = LogManager.getLogger(MyBeanWithDependencyImpl.class);

    private final MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printDependency(int number) {
        int result = myOperation.add(number);
        LOGGER.info("Hi! Im a new dependency with a bean... and the number given after the process is {}", result);
    }
}