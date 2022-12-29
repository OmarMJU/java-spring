package com.omju.springboot.service;

import org.springframework.transaction.annotation.Transactional;
import com.omju.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import com.omju.springboot.entity.User;
import org.apache.logging.log4j.Logger;
import java.util.List;

@Service
public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream().peek(user -> LOGGER.info("User inserted {}", user)).forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}