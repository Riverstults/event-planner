package com.example.demo.repository;
import com.example.demo.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository
     extends JpaRepository<Events,Long>{
      @Query("SELECT s FROM Events s WHERE s.name = ?1")
      Optional<Events>findEventsByName(String name);
}
