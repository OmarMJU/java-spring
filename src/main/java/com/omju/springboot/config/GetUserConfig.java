package com.omju.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.omju.springboot.service.UserService;
import com.omju.springboot.crud.GetUserImpl;
import com.omju.springboot.crud.GetUser;

@Configuration
public class GetUserConfig {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImpl(userService);
    }
}