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

    @Override
    public User getById(Long id) {
        return userService.getById(id);
    }

    @Override
    public User insertUser(User newUser) {
        return userService.save(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        userService.delete(id);
    }

    @Override
    public User updateUser(User newUser, Long id) {
        return userService.update(newUser, id);
    }

    @Override
    public List<User> getUsers(int page, int size) {
        return userService.findAll(page, size);
    }
}
