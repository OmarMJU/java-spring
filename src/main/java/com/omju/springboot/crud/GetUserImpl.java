package com.omju.springboot.crud;

import com.omju.springboot.service.UserService;
import com.omju.springboot.entity.User;
import java.util.List;

public class GetUserImpl implements GetUser {
    private final UserService userService;

    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
