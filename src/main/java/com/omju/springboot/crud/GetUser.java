package com.omju.springboot.crud;

import com.omju.springboot.entity.User;
import java.util.List;

public interface GetUser {
    List<User> getAll();
}