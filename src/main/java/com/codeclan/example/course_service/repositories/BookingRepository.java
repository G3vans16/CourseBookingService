package com.codeclan.example.course_service.repositories;

import com.codeclan.example.course_service.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDateIgnoreCase (String date);
}
