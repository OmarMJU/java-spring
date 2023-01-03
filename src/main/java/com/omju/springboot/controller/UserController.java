package com.omju.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User user) {
        return new ResponseEntity<>(getUser.insertUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<User> deleteUser(@PathVariable Long id) {
        getUser.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return new ResponseEntity<>(getUser.updateUser(newUser, id), HttpStatus.OK);
    }
}
