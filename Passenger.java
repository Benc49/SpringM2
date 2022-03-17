package com.example.demo.passenger;

import com.example.demo.flight.Flight;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @JsonIgnore
    @ManyToMany(mappedBy = "flightPassengers")
    private Set<Flight> flights = new HashSet<>();

    private String name;

    public Passenger() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Flight> getFlights() {
        return flights;
    }
}
