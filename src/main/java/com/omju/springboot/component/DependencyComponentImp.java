package com.omju.springboot.component;

import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class DependencyComponentImp implements DependencyComponent {
    private static final Logger LOGGER = LogManager.getLogger(DependencyComponentImp.class);

    @Override
    public void greeting() {
        LOGGER.info("This is greeting");
    }
}