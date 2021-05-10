package com.example.demo.repository;

import com.example.demo.configuration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {

    long findById(String userId);

    long findByUserId(Long userId);
}
