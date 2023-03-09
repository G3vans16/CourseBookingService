package com.codeclan.example.course_service.controllers;

import com.codeclan.example.course_service.models.Course;
import com.codeclan.example.course_service.models.Customer;
import com.codeclan.example.course_service.repositories.CourseRepository;
import com.codeclan.example.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
    ){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
