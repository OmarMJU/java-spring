package com.omju.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import com.omju.springboot.bean.ConfigPropertiesBeanImpl;
import com.omju.springboot.bean.ConfigPropertiesBean;
import org.springframework.context.annotation.Bean;
import com.omju.springboot.pojo.UserPojo;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class ConfigurationProperties {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastName;

    @Bean
    public ConfigPropertiesBean functionConfig() {
        return new ConfigPropertiesBeanImpl(lastName, name);
    }
}