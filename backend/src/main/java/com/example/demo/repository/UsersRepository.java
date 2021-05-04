package com.example.demo.repository;


import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findByLastName(@Param("lastname") String lastname);

    List<Users> findByFirstName(@Param("firstname") String firstname);

}
