package com.example.demo.passenger;

import com.example.demo.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
