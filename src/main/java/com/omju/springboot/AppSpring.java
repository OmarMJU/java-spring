package com.omju.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import com.omju.springboot.component.DependencyComponent;
import com.omju.springboot.bean.MyBeanWithDependency;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.omju.springboot.bean.MyBean;

@SpringBootApplication
public class AppSpring implements CommandLineRunner {
    private static final Logger LOGGER = LogManager.getLogger(AppSpring.class);

    private final MyBeanWithDependency myBeanWithDependency;
    private final DependencyComponent dependencyComponent;
    private final MyBean myBean;

    public AppSpring(@Qualifier("dependencyTwoComponentImpl") DependencyComponent dependencyComponent, MyBean myBean, MyBeanWithDependency myBeanWithDependency) {
        this.myBeanWithDependency = myBeanWithDependency;
        this.dependencyComponent = dependencyComponent;
        this.myBean = myBean;
    }

    public static void main(String[] args) {
        LOGGER.info("Spring boot app... Start!!!");
        SpringApplication.run(AppSpring.class, args);
    }

    @Override
    public void run(String... args) {
        dependencyComponent.greeting();
        myBean.print();
        myBean.displayName("Omar");
        myBeanWithDependency.printDependency(5);
    }
}