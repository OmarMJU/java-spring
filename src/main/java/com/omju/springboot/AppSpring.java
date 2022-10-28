package com.omju.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.omju.springboot.component.DependencyComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class AppSpring implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(AppSpring.class);

    private final DependencyComponent dependencyComponent;

    public AppSpring(@Qualifier("dependencyTwoComponentImpl") DependencyComponent dependencyComponent) {
        this.dependencyComponent = dependencyComponent;
    }

    public static void main(String[] args) {
        LOGGER.info("Spring boot app... Start!!!");
        SpringApplication.run(AppSpring.class, args);
    }

    @Override
    public void run(String... args) {
        dependencyComponent.greeting();
    }
}