package com.example.demo.repository;


import com.example.demo.model.Gifts;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface GiftsRepository extends JpaRepository<Gifts, Long> {


}
