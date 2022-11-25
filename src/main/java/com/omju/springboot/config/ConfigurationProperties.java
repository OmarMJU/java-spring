package com.omju.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import com.omju.springboot.bean.ConfigPropertiesBeanImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import com.omju.springboot.bean.ConfigPropertiesBean;
import org.springframework.context.annotation.Bean;
import com.omju.springboot.pojo.UserPojo;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class ConfigurationProperties {
    @Value("${value.lastname}")
    private String lastName;

    @Value("${value.name}")
    private String name;

    @Bean
    public ConfigPropertiesBean functionConfig() {
        return new ConfigPropertiesBeanImpl(lastName, name);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");

        return dataSourceBuilder.build();
    }
}