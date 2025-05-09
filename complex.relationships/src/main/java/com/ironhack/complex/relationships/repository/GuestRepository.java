package com.ironhack.complex.relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.complex.relationships.model.Guest;
import com.ironhack.complex.relationships.model.Guest.GuestStatus;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
    List<Guest> findByStatus(GuestStatus status);

    List<Guest> findByEventId(Integer eventId);
}
