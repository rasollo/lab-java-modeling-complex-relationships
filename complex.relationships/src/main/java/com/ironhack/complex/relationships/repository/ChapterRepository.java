package com.ironhack.complex.relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ironhack.complex.relationships.model.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

}
