package com.example.demo.destination;

import com.example.demo.passenger.Passenger;
import com.example.demo.passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationController {
    @Autowired
    DestinationRepository destinationRepository;

    @GetMapping
    List<Destination> getDestination(){return destinationRepository.findAll();}

    @PostMapping
    Destination createDestination(@RequestBody Destination destination){return destinationRepository.save(destination);}

}
