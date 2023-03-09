package com.codeclan.example.course_service.components;

import com.codeclan.example.course_service.models.Booking;
import com.codeclan.example.course_service.models.Course;
import com.codeclan.example.course_service.models.Customer;
import com.codeclan.example.course_service.repositories.BookingRepository;
import com.codeclan.example.course_service.repositories.CourseRepository;
import com.codeclan.example.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) {
        Customer dan = new Customer("Dan", "Kent", 23);
        customerRepository.save(dan);

        Course course1 = new Course("PSD", "Edinburgh", 5);
        courseRepository.save(course1);

        Booking booking1 = new Booking("28-11-22");
        bookingRepository.save(booking1);
    }
}
