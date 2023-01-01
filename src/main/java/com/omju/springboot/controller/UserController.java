package com.omju.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.omju.springboot.crud.GetUser;
import com.omju.springboot.entity.User;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final GetUser getUser;

    public UserController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }
}
