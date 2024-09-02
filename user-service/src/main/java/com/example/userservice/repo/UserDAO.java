package com.example.userservice.repo;

import com.example.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserDAO extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);

}
