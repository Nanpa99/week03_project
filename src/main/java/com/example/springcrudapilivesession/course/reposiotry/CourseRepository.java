package com.example.springcrudapilivesession.course.reposiotry;

import com.example.springcrudapilivesession.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
