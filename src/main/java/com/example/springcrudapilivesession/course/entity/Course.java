package com.example.springcrudapilivesession.course.entity;

import com.example.springcrudapilivesession.course.dto.CourseReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String instructors;
    private Double cost;

    public Course(CourseReqDto courseReqDto) {
        this.title = courseReqDto.getTitle();
        this.instructors = courseReqDto.getInstructors();
        this.cost = courseReqDto.getCost();
    }

    public void courseUpdate(CourseReqDto courseReqDto) {
        this.title = courseReqDto.getTitle() != null ? courseReqDto.getTitle() : this.title;
        this.instructors = courseReqDto.getInstructors() != null ? courseReqDto.getInstructors() : this.instructors;
        this.cost = courseReqDto.getCost() != null ? courseReqDto.getCost() : this.cost;
    }

}
