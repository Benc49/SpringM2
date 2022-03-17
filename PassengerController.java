package com.example.demo.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

        @Autowired
        PassengerRepository passengerRepository;

        @GetMapping
        List<Passenger> getPassenger(){return passengerRepository.findAll();}

        @PostMapping
        Passenger createPassenger(@RequestBody Passenger passenger){return passengerRepository.save(passenger);}
    }
