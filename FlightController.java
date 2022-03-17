package com.example.demo.flight;

import com.example.demo.destination.Destination;
import com.example.demo.destination.DestinationRepository;
import com.example.demo.passenger.Passenger;
import com.example.demo.passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    DestinationRepository destinationRepository;

    @GetMapping
    List<Flight> getFlight(){return flightRepository.findAll();}

    @PostMapping
    Flight createFlight(@RequestBody Flight flight){return flightRepository.save(flight);}

    @PutMapping("/{flightId}/passengers/{passengerId}")
    Flight boardPassengerToFlight(
            @PathVariable Long flightId,
            @PathVariable Long passengerId
    ){
        Flight flight = flightRepository.findById(passengerId).get();
        Passenger passenger = passengerRepository.findById(passengerId).get();
        flight.boardPassenger(passenger);
        return flightRepository.save(flight);
    }

    @PutMapping("/{flightId}/destination/{destinationId}")
    Flight assignFlightToDestination(
            @PathVariable Long flightId,
            @PathVariable Long destinationId
    ){
        Flight flight = flightRepository.findById(destinationId).get();
        Destination destination = destinationRepository.findById(destinationId).get();
        flight.assignDestination(destination);
        return flightRepository.save(flight);
    }

}
