package com.example.demo.repository;


import com.example.demo.configuration.entity.Event;
import com.example.demo.model.EventRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, Long> {
    EventRequest findByEventId(Long eventId);
}
