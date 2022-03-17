package com.example.demo.destination;

import com.example.demo.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
