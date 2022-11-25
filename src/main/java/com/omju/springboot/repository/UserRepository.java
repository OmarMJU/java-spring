package com.omju.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.omju.springboot.entity.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from Users u where u.email=:email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);
}

/**
 * Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException:
 * Error creating bean with name 'appSpring': Unsatisfied dependency expressed through constructor parameter 5; nested exception is org.springframework.beans.factory.BeanCreationException:
 * Error creating bean with name 'userRepository' defined in com.omju.springboot.repository.UserRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration:
 * Invocation of init method failed; nested exception is org.springframework.data.repository.query.QueryCreationException:
 * Could not create query for public abstract java.util.Optional com.omju.springboot.repository.UserRepository.findUserByEmail(java.lang.String); Reason:
 * Validation failed for query for method public abstract java.util.Optional com.omju.springboot.repository.UserRepository.findUserByEmail(java.lang.String)!;
 * nested exception is java.lang.IllegalArgumentException:
 * Validation failed for query for method public abstract java.util.Optional com.omju.springboot.repository.UserRepository.findUserByEmail(java.lang.String)!
 *
 *
 * org.springframework.data.repository.query.QueryCreationException: Could not create query for public abstract java.util.Optional com.omju.springboot.repository.UserRepository.findUserByEmail(java.lang.String);
 *
 * java.lang.IllegalArgumentException: Validation failed for query for method public abstract java.util.Optional com.omju.springboot.repository.UserRepository.findUserByEmail(java.lang.String)!
 */

