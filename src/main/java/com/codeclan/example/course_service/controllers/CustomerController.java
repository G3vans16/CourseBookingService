package com.codeclan.example.course_service.controllers;

import com.codeclan.example.course_service.models.Customer;
import com.codeclan.example.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "course_id", required = false) Long courseId,
            @RequestParam(name = "age", required = false) Integer age
    ){
        if(town != null && age != null && courseId != null){
            return new ResponseEntity<>(customerRepository.findByTownAndAgeGreaterThanAndBookingsCourseId(town, age, courseId), HttpStatus.OK);
        }
        if(town != null && courseId != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseId(town, courseId), HttpStatus.OK);
        }
        if(courseId != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(courseId), HttpStatus.OK);
        }
        if(town != null){
            return new ResponseEntity<>(customerRepository.findByTown(town), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
