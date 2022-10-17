package com.example.springcrudapilivesession.course.service;

import com.example.springcrudapilivesession.course.dto.CourseListResDto;
import com.example.springcrudapilivesession.course.dto.CourseReqDto;
import com.example.springcrudapilivesession.course.dto.CourseResDto;
import com.example.springcrudapilivesession.course.entity.Course;
import com.example.springcrudapilivesession.course.reposiotry.CourseRepository;
import com.example.springcrudapilivesession.global.GlobalResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public GlobalResDto saveCourse(CourseReqDto courseReqDto) {

        courseRepository.save(new Course(courseReqDto));

        return new GlobalResDto("Success Save Course", HttpStatus.OK.value());
    }

    @Transactional(readOnly = true)
    public ResponseEntity<CourseResDto> getCourse(Long id) {

        Course course = checkCourse(courseRepository, id);

        return ResponseEntity.ok(new CourseResDto(course));
    }

    @Transactional(readOnly = true)
    public CourseListResDto getCourses() {

        CourseListResDto courseListResDto = new CourseListResDto();
        List<Course> courses = courseRepository.findAll();

        for (Course course : courses) {
            courseListResDto.addCourse(new CourseResDto(course));
        }

        return courseListResDto;
    }

    @Transactional
    public GlobalResDto updateCourse(Long id, CourseReqDto courseReqDto) {

        Course course = checkCourse(courseRepository, id);
        course.courseUpdate(courseReqDto);

        return new GlobalResDto("Success Update Course", HttpStatus.OK.value());

    }

    @Transactional
    public GlobalResDto deleteCourse(Long id) {
        Course course = checkCourse(courseRepository, id);
        courseRepository.delete(course);
        return new GlobalResDto("Success Delete Course", HttpStatus.OK.value());
    }

    private Course checkCourse(CourseRepository courseRepository, Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Course")
        );
    }

}
