package com.omju.springboot.crud;

import com.omju.springboot.entity.User;
import java.util.List;

public interface GetUser {
    List<User> getAll();
    User getById(Long id);
    User insertUser(User newUser);
    void deleteUser(Long id);
    User updateUser(User newUser, Long id);
}
