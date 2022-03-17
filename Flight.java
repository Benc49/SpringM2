package com.example.demo.flight;

import com.example.demo.destination.Destination;
import com.example.demo.passenger.Passenger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Flight{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;





    @ManyToMany
    @JoinTable(
            name = "passenger_boarded",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private Set<Passenger> flightPassengers = new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private Destination destination;

    public Destination getDestination() {
        return destination;
    }

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

    public Set<Passenger> getFlightPassengers() {
        return flightPassengers;
    }

    public void boardPassenger(Passenger passenger) {
        flightPassengers.add(passenger);
    }

    public void assignDestination(Destination destination) {
        this.destination = destination;
    }
}
