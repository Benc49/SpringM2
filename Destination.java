package com.example.demo.destination;

import com.example.demo.flight.Flight;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    private Set<Flight> flights = new HashSet<>();



    private String name;

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
