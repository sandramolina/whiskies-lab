package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskys/year")
    public ResponseEntity<List<Whisky>> getWhiskysByYear(@RequestParam(name = "year") int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    //we can query this on the browser at http://localhost:8080/whiskys?distillery=26&&age=18
    @GetMapping(value = "/whiskys")
    public  ResponseEntity<List<Whisky>> getWhiskyByDistilleryAndAge(
            @RequestParam(name = "distillery") Long distillery, @RequestParam(name = "age") int age){
        return new ResponseEntity<>(whiskyRepository.findByDistillery_IdAndAge(distillery, age), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys/distilleryRegion")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name="distilleryRegion") String region){
        return new ResponseEntity<>(whiskyRepository.findByDistillery_Region(region), HttpStatus.OK);
    }
}
