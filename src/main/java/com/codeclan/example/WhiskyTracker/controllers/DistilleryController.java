package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {
    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries/region")
    public ResponseEntity<List<Distillery>> getDistilleryByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/whiskyAge")
    public ResponseEntity<List<Distillery>> getDistilleryWithWhiskiesAtCertainAge(@RequestParam(name = "whiskyAge") int age){
        return new ResponseEntity<>(distilleryRepository.findByWhiskies_AgeGreaterThanEqual(age), HttpStatus.OK);
    }

}
