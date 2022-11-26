package com.omju.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.omju.springboot.entity.User;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from Users u where u.email=:email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "select * from Users u where u.name like :name% order by u.id_user desc", nativeQuery = true)
    List<User> findUsersByName(@Param("name") String name);

    // Query Methods.
    Optional<User> findById(Long id);
    Optional<User> findByNameAndEmail(String name, String email);
    List<User> findByNameLike(String partName);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
    List<User> findByNameLikeOrderByIdDesc(String name);
    List<User> findByNameContainingOrderByIdAsc(String name);
}