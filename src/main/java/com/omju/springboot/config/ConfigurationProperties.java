package com.omju.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import com.omju.springboot.bean.ConfigPropertiesBeanImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import com.omju.springboot.bean.ConfigPropertiesBean;
import org.springframework.context.annotation.Bean;
import com.omju.springboot.pojo.UserPojo;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class ConfigurationProperties {
    @Value("${value.lastname}")
    private String lastName;

    @Value("${value.name}")
    private String name;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public ConfigPropertiesBean functionConfig() {
        return new ConfigPropertiesBeanImpl(lastName, name);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();
    }
}