package com.codeclan.example.course_service.repositories;

import com.codeclan.example.course_service.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStarRating(Integer starRating);
    List<Course> findByBookingsCustomerId(Long id);
}
