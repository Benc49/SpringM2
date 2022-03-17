package com.example.demo.flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long>  {

        //    @Query("SELECT s FROM s WHERE s.email=?1")
    }

