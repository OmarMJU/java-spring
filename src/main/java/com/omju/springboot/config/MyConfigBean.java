package com.omju.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.omju.springboot.bean.*;

@Configuration
public class MyConfigBean {

    @Bean
    public MyBean myBeanConfigBean() {
//      return new MyBeanImpl(); // This the first implementation of the dependency...
        return new MyBeanTwoImpl(); // Only change this BEAN and you can execute another different thing.
    }

    @Bean
    public MyOperation myOperationConfigBean() {
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependency myBeanWithDependencyConfigBean(MyOperation myOperation) {
        return new MyBeanWithDependencyImpl(myOperation);
    }
}
