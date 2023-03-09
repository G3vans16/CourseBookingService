package com.codeclan.example.course_service.controllers;

import com.codeclan.example.course_service.models.Booking;
import com.codeclan.example.course_service.models.Customer;
import com.codeclan.example.course_service.repositories.BookingRepository;
import com.codeclan.example.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
    ){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
}
