package com.ironhack.complex.relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.complex.relationships.model.Event;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByDateBetween(Date start, Date end);

    List<Event> findByTitleContaining(String title);
}