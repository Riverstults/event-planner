package com.example.demo.repository;

import com.example.demo.Entity.Vendors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository
     extends JpaRepository<Vendors,Long>{
    @Query("SELECT s FROM Vendors s WHERE s.email = ?1")
Optional<Vendors>findVendorsByEmail(String email);
}
