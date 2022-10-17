package com.example.springcrudapilivesession.course.controller;

import com.example.springcrudapilivesession.course.dto.CourseListResDto;
import com.example.springcrudapilivesession.course.dto.CourseReqDto;
import com.example.springcrudapilivesession.course.dto.CourseResDto;
import com.example.springcrudapilivesession.course.service.CourseService;
import com.example.springcrudapilivesession.global.GlobalResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/save/course")
    public GlobalResDto saveCourse(@RequestBody CourseReqDto courseReqDto) {
        return courseService.saveCourse(courseReqDto);
    }

    @GetMapping("/get/course/{id}")
    public ResponseEntity<CourseResDto> getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @GetMapping("/get/courses")
    public CourseListResDto getCourses() {
        return courseService.getCourses();
    }

    @PutMapping("/update/course/{id}")
    public GlobalResDto updateCourse(@PathVariable Long id, @RequestBody CourseReqDto courseReqDto) {
        return courseService.updateCourse(id, courseReqDto);
    }

    @DeleteMapping("/delete/course/{id}")
    public GlobalResDto deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

}
