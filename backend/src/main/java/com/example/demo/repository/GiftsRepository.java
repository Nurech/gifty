package com.example.demo.repository;

import com.example.demo.configuration.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GiftsRepository extends JpaRepository<Gift, Long> {


}
