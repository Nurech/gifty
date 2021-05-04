package com.example.demo.repository;



import com.example.demo.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Long> {


}
