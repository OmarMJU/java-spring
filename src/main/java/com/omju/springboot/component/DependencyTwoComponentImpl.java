package com.omju.springboot.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DependencyTwoComponentImpl implements DependencyComponent {
    private static final Logger LOGGER = LogManager.getLogger(DependencyTwoComponentImpl.class);

    @Override
    public void greeting() {
        LOGGER.info("This an other one greeting 😱!!");
    }
}
