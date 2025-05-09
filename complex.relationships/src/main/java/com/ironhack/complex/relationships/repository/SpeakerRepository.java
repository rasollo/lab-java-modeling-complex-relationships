package com.ironhack.complex.relationships.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.complex.relationships.model.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {
    List<Speaker> findByConferenceId(Integer conferenceId);
}