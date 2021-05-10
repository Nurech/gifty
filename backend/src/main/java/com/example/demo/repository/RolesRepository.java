package com.example.demo.repository;

import com.example.demo.configuration.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
    Role findAllByUserId(long userId);
}
