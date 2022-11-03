package com.omju.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.omju.springboot.bean.MyBeanTwoImpl;
import com.omju.springboot.bean.MyBeanImpl; // The first implementation of this bean.
import com.omju.springboot.bean.MyBean;

@Configuration
public class MyConfigBean {

    @Bean
    public MyBean beanOperation() {
//      return new MyBeanImpl(); // This the first implementation of the dependency...
        return new MyBeanTwoImpl(); // Only change this BEAN and you can execute another different thing.
    }
}
