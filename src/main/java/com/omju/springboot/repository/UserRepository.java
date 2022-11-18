package com.omju.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.omju.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
