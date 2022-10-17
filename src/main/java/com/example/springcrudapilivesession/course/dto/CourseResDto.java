package com.example.springcrudapilivesession.course.dto;

import com.example.springcrudapilivesession.course.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseResDto {

    private String title;
    private String instructors;
    private Double cost;

    public CourseResDto(Course course) {
        this.title = course.getTitle();
        this.instructors = course.getInstructors();
        this.cost = course.getCost();
    }

}
