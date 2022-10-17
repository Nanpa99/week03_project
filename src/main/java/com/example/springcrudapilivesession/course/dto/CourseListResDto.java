package com.example.springcrudapilivesession.course.dto;

import com.example.springcrudapilivesession.global.GlobalResDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.LinkedList;
import java.util.List;

@Getter
public class CourseListResDto extends GlobalResDto {

    List<CourseResDto> courses = new LinkedList<>();

    public CourseListResDto() {super("Supper Find List", HttpStatus.OK.value());}

    public void addCourse(CourseResDto course) {
        courses.add(course);
    }

}
